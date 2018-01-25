<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\DB;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Menu;

class AddMenuController extends Controller
{
    public function create(Request $request)
    {
        $id = $request->input('id');
        return view('addmenu', compact('id', 'reviews'));
    }
    
    public function store(Request $request)
    {
        $this->validate($request, [
            'id' => 'required|max:255',
            'name' => 'required|max:255',
            'description' => 'required|max:255',
            'price' => 'required|max:255',
        ]);
        
        
        $menu = Menu::create([
            'id' => $request->id,
            'name' => $request->name,
            'description' => $request->description,
            'price' => $request->price,
       ]);
       return redirect('/restaurants');
    }}
