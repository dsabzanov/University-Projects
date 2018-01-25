<?php

namespace App;

use Illuminate\Database\Eloquent\Model;


class Restaurant extends Model
{
    protected $fillable = [
        'name', 
        'streetaddress', 
        'city',
        'state',
        'website'
    ];
}
