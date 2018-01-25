@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">My Profile</div>

                <div class="panel-body">
                    <p>Name: {{Auth::user()->name}}</p>
                    <p>Email Address: {{Auth::user()->email}}</p>
                    <p>Registration Date: {{date('F d, Y g:i A', strtotime(Auth::user()->created_at))}}</p>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
