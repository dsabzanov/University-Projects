<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\DB;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Hours;

class AddHoursController extends Controller
{
    public function create(Request $request)
    {
        $id = $request->input('id');
        return view('addhours', compact('id', 'reviews'));
    }
    
    public function store(Request $request)
    {
        $this->validate($request, [
            'id' => 'required|max:255',
            'day' => 'required|max:255',
            'starttime' => 'required|max:255',
            'endtime' => 'required|max:255',
        ]);
        
        
        $hours = Hours::create([
            'id' => $request->id,
            'day' => $request->day,
            'starttime' => $request->starttime,
            'endtime' => $request->endtime,
       ]);
       return redirect('/restaurants');
    }
}
