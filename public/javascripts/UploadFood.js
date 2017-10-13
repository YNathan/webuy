app.controller('uploadfood', ['$scope', '$http', '$state', '$interval', '$mdDialog', '$mdSidenav', 'ShamayimFunctions', '$rootScope', function ($scope, $http, $state, $interval, $mdDialog, $mdSidenav, ShamayimFunctions, $rootScope) {
    $rootScope.isLogin = true;
    $scope.files;
    $scope.strCaptionDragAndDrop = "Drag & drop files here...";
    // Just print kind of 'hay message'
    $scope.message = 'M. ' + ShamayimFunctions.getCookie("username");

    $scope.productToUpload = {
        "tags": [],
        "companyName": "",
        "productName": "",
        "maxPrice": null,
        "minPrice": null,
        "productId": null,
        "sellerId": 3
    }

    $scope.userName = ShamayimFunctions.getCookie("username");


    // Just check if there is a user name
    if (ShamayimFunctions.getCookie("username") == null) {
        // Go to the main application
        $state.go('wellcom');
    }


    //  $scope.items = [1, 2, 3, 4, 5];
    $scope.selected = [];
    $scope.toggle = function (item, list) {
        var idx = list.indexOf(item);
        if (idx > -1) {
            list.splice(idx, 1);
        } else {
            list.push(item);
        }
    };
    $scope.exists = function (item, list) {
        return list.indexOf(item) > -1;
    };


    $scope.files;
    // product Pictures Section
    $scope.$watch('files.length', function (newVal, oldVal) {
        console.log($scope.files);
    });


    $scope.uploadProduct = function () {
        var formData = new FormData();
        for (var index = 0; index < $scope.files.length; index++) {
            console.log($scope.files[index].lfFile);
            formData.append('files[]', $scope.files[index].lfFile);
        }

        // Getting the seller id
        $scope.userName = ShamayimFunctions.getCookie("username");
        var sellerId = -1;
        $http.get('/GET_USER_ID/' + $scope.userName).then(function (result) {
            sellerId = result.data;
            $scope.productToUpload.sellerId = sellerId;

            formData.append('ProductToUpload', JSON.stringify($scope.productToUpload));
            $http.post('/INSERT_PRODUCT', formData, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            }).then(function (result) {
                //alert(result);
            }, function (err) {
                //alert(err);
            });
        }, function (err) {
            //alert(err);
        });
    }

    function isInArray(arr, str) {
        var bool = false;
        angular.forEach(arr, function (tag, key) {
            if (angular.equals(tag, str)) {
                bool = true;
            }
        });

        return bool;
    }

    $scope.listOfProductEntitys;
    $scope.listOfTags = [];
    // Get information conserning the
    $http.get("/GET_ALL_PRODUCTS")
        .then(function successCallback(response) {
                $scope.listOfProductEntitys = response.data;
                angular.forEach($scope.listOfProductEntitys, function (productEntity, key) {
                    angular.forEach(productEntity.tags, function (tag, key) {
                        if (!isInArray($scope.listOfTags, tag)) {
                            $scope.listOfTags.push(tag);
                            console.log(tag);
                        }
                    });
                });
            },
            function error(response) {
                ShamayimFunctions.showAlert("Your attention please", response.data, "cant load products");
            });

    $scope.getProductsByTags = function (tagSelected) {
        // Get all products
        $http.get("/GET_PRODUCTS_BY_TAG/"+tagSelected)
            .then(function successCallback(response) {
                    $scope.listOfProductEntitys = response.data;
                    angular.forEach($scope.listOfProductEntitys, function (productEntity, key) {
                        angular.forEach(productEntity.tags, function (tag, key) {
                            if (!isInArray($scope.listOfTags, tag)) {
                                $scope.listOfTags.push(tag);
                                console.log(tag);
                            }
                        });
                    });
                },
                function error(response) {
                    ShamayimFunctions.showAlert("Your attention please", response.data, "cant load products");
                });


    }


}]);
