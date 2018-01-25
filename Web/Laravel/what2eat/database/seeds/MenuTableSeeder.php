<?php

use Illuminate\Database\Seeder;

class MenuTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('menu')->insert([
            ['id' => 1, 'name' => 'Pizza1', 'description' => 'Cheese Pizza', 'price' => '14'],
            ['id' => 1, 'name' => 'Pizza2', 'description' => 'Pepperoni Pizza', 'price' => '16'],
            ['id' => 2, 'name' => 'Burger1', 'description' => 'Cheeseburger', 'price' => '2'],
            ['id' => 2, 'name' => 'Burger2', 'description' => 'Veggie Burger', 'price' => '4'],
        ]);    }
}
