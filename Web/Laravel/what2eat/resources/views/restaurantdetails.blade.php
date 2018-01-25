@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Restaurant Details</div>

                <div class="panel-body">
                    <h3>{{ $restaurantdetails->name }}</h3> 
                    @if (Auth::check())
                        @if (Auth::user()->admin == 1)
                            <a href="editrestaurant?id={{ $restaurantdetails->id }}">Edit Restaurant</a>
                            <a href="addhours?id={{ $restaurantdetails->id }}">Add Operating Hours</a>
                            <a href="addmenu?id={{ $restaurantdetails->id }}">Add Menu Item</a>
                        @elseif (Auth::user()->admin == 0)
                            <a href="addreview?id={{ $restaurantdetails->id }}">Add Review</a>
                        @endif
                    @endif
                    <h4>Average Rating: </h4>{{ $average }}
                    <h4>Restaurant Info: </h4>
                    <p>{{ $restaurantdetails->streetaddress }}</p>
                    <p>{{ $restaurantdetails->city }}, {{ $restaurantdetails->state }}</p>
                    <p><a href="{{ $restaurantdetails->website }}">{{ $restaurantdetails->website }}</a></p>
                    
                    <h4>Hours: </h4>
                    @foreach ($hours as $hour)
                        <p>{{ $hour->day }}: {{ $hour->starttime }} to {{ $hour->endtime }}</p>
                    @endforeach
                    
                    <h4>Menu: </h4>
                    @foreach ($menus as $menu)
                        <p>{{ $menu->name }}</p>
                        <p>Price: ${{ $menu->price }}</p>
                        <p>Description: {{ $menu->description }}</p>
                    @endforeach
                    
                    <h4>Reviews: </h4>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection