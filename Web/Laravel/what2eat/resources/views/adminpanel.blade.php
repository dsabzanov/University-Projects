@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Admin Panel</div>

                <div class="panel-body">
                    <a href="addrestaurant">Add Restaurant</a>
                    <a href="users">Users</a>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
