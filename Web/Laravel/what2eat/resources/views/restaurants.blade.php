@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Restaurants</div>

                <div class="panel-body">
                    @foreach($restaurants as $restaurant)
                        <h3>{{ $restaurant->name }}</h3> 
                        <p>Located in {{ $restaurant->city }}, {{ $restaurant->state }}</p>
                        <a href="restaurantdetails?id={{ $restaurant->id }}">View Restaurant Details</a>
                    @endforeach
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
