@extends('layouts.app')

@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="panel panel-default">
                <div class="panel-heading">Add Review</div>

                <div class="panel-body">
                    <form class="form-horizontal" role="form" method="POST" action="addreview">
                        {{ csrf_field() }}

                        <div class="form-group">
                            <input id="id" type="hidden" class="form-control" name="id" value="{{ $id }}" required>
                        </div>
                        
                        
                        <div class="form-group">
                            <label for="rating" class="col-md-4 control-label">Rating</label>
                            <div class="col-md-6">
                                <select class="form-control" id="rating" name="rating" required>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>
                        </div>
                        
                        

                        <div class="form-group{{ $errors->has('tagline') ? ' has-error' : '' }}">
                            <label for="tagline" class="col-md-4 control-label">Tagline</label>

                            <div class="col-md-6">
                                <input id="tagline" type="text" class="form-control" name="tagline" value="{{ old('tagline') }}" required>

                                @if ($errors->has('tagline'))
                                    <span class="help-block">
                                        <strong>{{ $errors->first('tagline') }}</strong>
                                    </span>
                                @endif
                            </div>
                        </div>

                        <div class="form-group{{ $errors->has('content') ? ' has-error' : '' }}">
                            <label for="content" class="col-md-4 control-label">Content</label>

                            <div class="col-md-6">
                                <textarea class="form-control" id="content" rows="3" name="content" required></textarea>

                                @if ($errors->has('content'))
                                    <span class="help-block">
                                        <strong>{{ $errors->first('content') }}</strong>
                                    </span>
                                @endif
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <input id="reviewer" type="hidden" class="form-control" name="reviewer" value="{{Auth::user()->name}}" required>
                        </div>


                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-4">
                                <button type="submit" class="btn btn-primary">
                                    Add Review
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
