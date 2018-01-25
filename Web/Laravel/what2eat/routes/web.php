<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Auth::routes();

Route::get('/home', 'HomeController@index');

Route::get('restaurants', 'RestaurantsController@showRestaurants');

Route::get('restaurantdetails', 'RestaurantsController@showRestaurantDetails');

Route::get('adminpanel', function () {
    return view('adminpanel');
});

Route::get('users', 'AdminPanelController@showUsers');

Route::get('addrestaurant', 'RestaurantsController@create');

Route::post('addrestaurant', 'RestaurantsController@store');



Route::get('editrestaurant', 'RestaurantsController@displayFields');

Route::post('editrestaurant', 'RestaurantsController@update');


Route::get('addreview', 'AddReviewsController@create');

Route::post('addreview', 'AddReviewsController@store');

Route::get('addhours', 'AddHoursController@create');

Route::post('addhours', 'AddHoursController@store');

Route::get('addmenu', 'AddMenuController@create');

Route::post('addmenu', 'AddMenuController@store');


Route::get('myreviews', function () {
    return view('myreviews');
});

Route::get('myprofile', function () {
    return view('myprofile');
});