<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\DB;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Reviews;


class AddReviewsController extends Controller
{
    
    public function create(Request $request)
    {
        $id = $request->input('id');
        return view('addreview', compact('id', 'reviews'));
    }
    
    public function store(Request $request)
    {
        $this->validate($request, [
            'id' => 'required|max:255',
            'rating' => 'required|max:255',
            'tagline' => 'required|max:255',
            'content' => 'required|max:255',
            'reviewer' => 'required|max:255',
        ]);
        
        
        $review = Reviews::create([
            'id' => $request->id,
            'rating' => $request->rating,
            'tagline' => $request->tagline,
            'content' => $request->content,
            'reviewer' => $request->reviewer,
       ]);
       return redirect('/restaurants');
    }
}
