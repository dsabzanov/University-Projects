@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading"><h4>Users</h4></div>

                <div class="panel-body">
                    @foreach($users as $user)
                        <p>{{ $user->name }}</p> 
                        <p>{{ $user->email }}</p>
                        @if ($user->admin == 0)
                            <a href="#">Promote</a>
                        @else
                            <a href="#">Demote</a>
                        @endif
                    @endforeach
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
