<?php

use Illuminate\Database\Seeder;

class RestaurantsTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('restaurants')->insert([
            ['name' => 'Pizza Hut', 'streetaddress' => '10231 Reseda Blvd', 'city' => 'Northridge', 'state' => 'CA', 'website' => 'http://www.pizzahut.com'],
            ['name' => 'McDonald\'s', 'streetaddress' => '9101 Reseda Blvd', 'city' => 'Northridge', 'state' => 'CA', 'website' => 'http://www.mcdonalds.com']
        ]);
    }
}
