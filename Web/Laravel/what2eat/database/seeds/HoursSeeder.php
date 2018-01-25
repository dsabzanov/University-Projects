<?php

use Illuminate\Database\Seeder;

class HoursSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('hours')->insert([
            ['id' => 1, 'day' => 'Sunday', 'starttime' => '8am', 'endtime' => '5pm'],
            ['id' => 1, 'day' => 'Monday', 'starttime' => '2am', 'endtime' => '11pm'],
            ['id' => 2, 'day' => 'Tuesday', 'starttime' => '8am', 'endtime' => '6pm'],
            ['id' => 2, 'day' => 'Wednesday', 'starttime' => '6am', 'endtime' => '7pm'],
        ]);
    }
}
