<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\DB;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Restaurant;

class RestaurantsController extends Controller
{
    public function showRestaurants()
    {
        $restaurants = DB::table('restaurants')->get();
        return view('restaurants', compact('restaurants'));
    }
    
    public function showRestaurantDetails(Request $request)
    {
        $id = $request->input('id');
        $restaurantdetails = DB::table('restaurants')->where('id', $id)->first();
        $reviews = DB::table('reviews')->where('id', $id)->get();
        $sum = 0;
        $count = 0;
        foreach ($reviews as $review) 
        {
            $sum = $sum + $review->rating;
            $count++;
        }
        $average = $sum/$count;
        
        $hours = DB::table('hours')->where('id', $id)->get();
        $menus = DB::table('menu')->where('id', $id)->get();
        return view('restaurantdetails', compact('restaurantdetails', 'average', 'hours', 'menus', 'reviews'));
    }
    
    public function create()
    {
        return view('addrestaurant');
    }
    
    public function store(Request $request)
    {
        $this->validate($request, [
            'name' => 'required|max:255',
            'street' => 'required|max:255',
            'city' => 'required|max:255',
            'state' => 'required|max:255',
            'website' => 'nullable',
        ]);
        
        
        $restaurant = Restaurant::create([
            'name' => $request->name,
            'streetaddress' => $request->street,
            'city' => $request->city,
            'state' => $request->state,
            'website' => $request->website,
       ]);
       return redirect('/restaurants');
    }
    
    public function displayFields(Request $request)
    {
        $id = $request->input('id');
        $restaurant = DB::table('restaurants')->where('id', $id)->first();
        return view('editrestaurant', compact('restaurant'));
    }
    
    public function update(Request $request)
    {
        $id = $request->id;
        $restaurant = Restaurant::findOrFail($id);
        
        $restaurant->update([
            'name' => $request->name,
            'streetaddress' => $request->street,
            'city' => $request->city,
            'state' => $request->state,
            'website' => $request->website,
        ]);
        return redirect('/restaurants');
    }

}