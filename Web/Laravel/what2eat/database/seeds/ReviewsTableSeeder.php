<?php

use Illuminate\Database\Seeder;

class ReviewsTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('reviews')->insert([
            ['id' => 1, 'rating' => 1, 'tagline' => 'Worst Restaurant', 'content' => 'DONT eat here!', 'reviewer' => 'Don'],
            ['id' => 1, 'rating' => 5, 'tagline' => 'Best Pizzeria', 'content' => 'Food to die for!', 'reviewer' => 'James'],
            ['id' => 2, 'rating' => 3, 'tagline' => 'Meh!', 'content' => 'Food\'s ok. nothing special.', 'reviewer' => 'Maria'],
            ['id' => 2, 'rating' => 2, 'tagline' => 'I\'ve had better!', 'content' => 'Not the best place for burgers!', 'reviewer' => 'Jamie'],
        ]);
    }
}
