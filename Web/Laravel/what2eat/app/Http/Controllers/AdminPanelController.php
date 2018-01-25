<?php

namespace App\Http\Controllers;

use Illuminate\Support\Facades\DB;
use Illuminate\Http\Request;

class AdminPanelController extends Controller
{
    public function showUsers()
    {
        $users = DB::table('users')->get();
        return view('users', compact('users'));
    }
}
