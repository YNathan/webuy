var app = angular
    .module('MyApp', [
        'ui.router'
    ])
    .config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {

            $urlRouterProvider.otherwise('/home');

            // States
            $stateProvider
                .state('home', {
                    url: "/home",
                    templateUrl: 'tpl.html',
                    params : { veryLongParamHome: null, },
                })
                .state('parent', {
                    url: "/parent",
                    templateUrl: 'tpl.html',
                    params : { veryLongParamParent: null, },
                })
                .state('parent.child', {
                    url: "/child",
                    templateUrl: 'tpl.html',
                    params : { veryLongParamChild: null, },
                    controller: 'ChildCtrl',
                })
            ;
        }
    ])
    .controller('ChildCtrl', ['$scope', function ($scope) {
    }])
    .run(['$rootScope', '$state', '$stateParams',
        function ($rootScope, $state, $stateParams) {
            $rootScope.$state = $state;
            $rootScope.$stateParams = $stateParams;
        }])