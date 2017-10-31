app.controller('welcome', ['$scope', '$http', '$state', '$interval', '$mdDialog', '$mdSidenav', 'ShamayimFunctions', '$rootScope', function ($scope, $http, $state, $interval, $mdDialog, $mdSidenav, ShamayimFunctions, $rootScope) {

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
        $scope.listOfProductEntitys = [];
        $scope.listOfTags = [];
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



   ShamayimFunctions.setIsLoggedCookie("false");
    // Language Section

    $rootScope.Languages = {
        availableOptions: [],
        selectedOption: {
            id: '1',
            HouseLanguage: 'default'
        }
    };

   // $rootScope.Languages = ShamayimFunctions.getExistingLanguages();

    function getLanguage(szLanguageName) {
        // Get information conserning the house
        $http.get("/GET_LANGUAGE/" + szLanguageName)
            .then(function successCallback(response) {
                    $rootScope.dictionary = response.data;
                    $rootScope.pageDirection = $rootScope.dictionary.Dictionary[0].PageDirection;
                },
                function error(response) {
                   // ShamayimFunctions.showAlert("Your attention please", response.data, "cant load houses");
                });
        ShamayimFunctions.setLanguageCookie(szLanguageName);

    }


   // getLanguage("עברית");

    $rootScope.$watch('Languages.selectedOption', function (newVal, oldVal) {
        if (newVal != oldVal) {
            HouseLanguageName = newVal;
            getLanguage(newVal);

        }
    })

    // End Of Language Section


    function getLanguage(szLanguageName) {
        // Get information conserning the house
        $http.get("/GET_LANGUAGE/" + szLanguageName)
            .then(function successCallback(response) {
                    $rootScope.dictionary = response.data;
                    $rootScope.pageDirection = $rootScope.dictionary.Dictionary[0].PageDirection;
                },
                function error(response) {
                    //ShamayimFunctions.showAlert("Your attention please", response.data, "cant load houses");
                });
        ShamayimFunctions.setLanguageCookie(szLanguageName);

    }




   // getLanguage("עברית");


    $scope.setUpPage= function(){
        $scope.foodProfilePathesImages = {
            availableOptions: [],
            selectedOption: {
                id: '1',
                imagesSource: 'default'
            }
        };
    }
// End Of Getting Repas Section


    $rootScope.toggleLeft = function () {
        $mdSidenav('left').toggle();
    }
    $rootScope.goToCopyright = function () {
        $state.go('Copyright');
    }
    $rootScope.goToHouses = function () {
        $state.go('Houses');
    }
    $rootScope.goToNewHouse = function () {
        $state.go('NewOrEditHouse');
    }
    $rootScope.goToUploadFood = function () {
        $state.go('UploadFood');
    }
    $rootScope.goToSystemManager = function () {
        $state.go('Manager');
    }
    $rootScope.goToHouse = function () {
        $state.go('House');
    }
    $rootScope.goToProduct = function (productId) {
        $state.get('welcome').params.productId = productId;
        var a = $state.get('welcome').params.productId;
        console.log(a);
        $state.go('Product');
    }
    $rootScope.logout = function () {
        ShamayimFunctions.setIsLoggedCookie("false");
        $state.go('welcome');

    }
    $rootScope.showLrButton = function () {
        if (ShamayimFunctions.getIsLoggedCookie() == "true") {
            return false
        } else {
            return true;
        }
    }

// Dialog
    $scope.status = '  ';
    $scope.customFullscreen = false;

    $rootScope.Copyright = function (ev) {
        $mdDialog.show({
            controller: 'Copyright',
            templateUrl: 'template/Copyright.html',
            parent: angular.element(document.body),
            targetEvent: ev,
            clickOutsideToClose: true,
            flex: 0,
        })
            .then(function (answer) {
                $scope.status = 'You said the information was "' + answer + '".';
            }, function () {
                $scope.status = 'You cancelled the dialog.';
            });
    };

    function closeAlert() {
        $mdDialog.hide(alert, "finished");
        alert = undefined;
    }

    function DialogController($scope, $mdDialog) {
        $scope.hide = function () {
            $mdDialog.hide();
        };

        $scope.cancel = function () {
            $mdDialog.cancel();
        };

    }
    newMapLocation(12,'BOGRASHOV','tel aviv','israel')
    function newMapLocation(nNumberOfHouse, szStreetName, szCityName, szStateName) {
        var longitude = 0.0;
        var latitude = 0.0;

        // Get information conserning the house
        $http.get("https://maps.googleapis.com/maps/api/geocode/json?address=" + nNumberOfHouse + "," + szStreetName + "," + szCityName + "," + szStateName + "&key=AIzaSyDiEizMb95sLkzDtvQ-eRoZb-LzYmv2VVI")
            .then(function successCallback(response) {
                    latitude = response.data.results[0].geometry.location.lat;
                    longitude = response.data.results[0].geometry.location.lng;
                    var uluru = {
                        lat: latitude,
                        lng: longitude
                    };
                    var marker = new google.maps.Marker({
                        position: uluru,
                        map: map
                    });
                    var map = new google.maps.Map(document.getElementById('map'), {
                        zoom: 15,
                        center: uluru
                    });
                },
                function error(response) {
                    //ShamayimFunctions.showAlert("Your attention please", response.data, "cant load maps");
                });

    }
}]).directive('lazyLoad', function ($timeout) {
    return {
        restrict: 'A',
        scope: {},
        link: function (scope, elem, attrs) {
            $timeout(function () {
                elem.attr('src', attrs.llSrc)
            });
        },
    }
});
