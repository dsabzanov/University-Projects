<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Reviews extends Model
{
    protected $fillable = [
        'id', 
        'rating', 
        'tagline',
        'content',
        'reviewer'
    ];
}
