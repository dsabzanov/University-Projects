@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Add Restaurant Hours</div>

                <div class="panel-body">
                    <form class="form-horizontal" role="form" method="POST" action="addhours">
                        {{ csrf_field() }}

                        <div class="form-group">
                            <input id="id" type="hidden" class="form-control" name="id" value="{{ $id }}" required>
                        </div>
                        
                        
                        <div class="form-group">
                            <label for="day" class="col-md-4 control-label">Day</label>
                            <div class="col-md-6">
                                <select class="form-control" id="day" name="day" required>
                                    <option>Sunday</option>
                                    <option>Monday</option>
                                    <option>Tuesday</option>
                                    <option>Wednesday</option>
                                    <option>Thursday</option>
                                    <option>Friday</option>
                                    <option>Saturday</option>
                                </select>
                            </div>
                        </div>
                        
                        

                        <div class="form-group{{ $errors->has('starttime') ? ' has-error' : '' }}">
                            <label for="starttime" class="col-md-4 control-label">Start Time</label>

                            <div class="col-md-6">
                                <input id="starttime" type="text" class="form-control" name="starttime" value="{{ old('starttime') }}" required>

                                @if ($errors->has('starttime'))
                                    <span class="help-block">
                                        <strong>{{ $errors->first('starttime') }}</strong>
                                    </span>
                                @endif
                            </div>
                        </div>

                        <div class="form-group{{ $errors->has('endtime') ? ' has-error' : '' }}">
                            <label for="endtime" class="col-md-4 control-label">End Time</label>

                            <div class="col-md-6">
                                <input id="endtime" type="text" class="form-control" name="endtime" value="{{ old('endtime') }}" required>

                                @if ($errors->has('endtime'))
                                    <span class="help-block">
                                        <strong>{{ $errors->first('endtime') }}</strong>
                                    </span>
                                @endif
                            </div>
                        </div>
                        


                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-4">
                                <button type="submit" class="btn btn-primary">
                                    Add Restaurant Hours
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
@endsection
