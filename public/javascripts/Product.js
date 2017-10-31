app.controller('Product', ['$scope', '$http', '$state', '$interval', '$mdDialog', '$mdSidenav', 'ShamayimFunctions', '$rootScope', function ($scope, $http, $state, $interval, $mdDialog, $mdSidenav, ShamayimFunctions, $rootScope) {
    $scope.productId = $state.get('welcome').params.productId;
    $scope.product = null;

    $http.get("/GET_PRODUCT_BY_ID/" + $scope.productId)
        .then(function successCallback(response) {
                $scope.product = response.data;
            },
            function error(response) {
                ShamayimFunctions.showAlert("Your attention please", response.data, "cant load products");
            });


}])

