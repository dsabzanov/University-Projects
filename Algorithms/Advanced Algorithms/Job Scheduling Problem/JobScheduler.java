/*
Project #2
COMP 496
David Sabzanov
Borhan Alizadeh
April 6, 2017
*/

package jobscheduler;


import java.util.ArrayList;

public class JobScheduler
{
	private int nJobs;
	private Job[]  jobs;

	int length = 0;
	String[] bf;
	private int pcount = 0;

	

	//adds the jobs into jobs array
	public JobScheduler( int[] joblength, int[] deadline, int[] profit)
	{
		//Set nJobs
		//Fill jobs array. The kth job entered has JobNo = k;
		nJobs = joblength.length;
		jobs = new Job[nJobs];
		for (int i = 0; i < joblength.length; i++) {
			Job jb = new Job(i, joblength[i], deadline[i], profit[i]);
			jobs[i] = jb;
		}
                printJobs();
	}

        
        //helper method to call permutation
	public void permutation(String str) {
		permutation("", str);
	}

	//gives us all the combination of mutiple digits
	private void permutation(String prefix, String str) {
		int n = str.length();

		if (n == 0){
			bf[pcount] = prefix;
			pcount++;
		}
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
		}
	}

	//gives us the factorial result of a digit
	public static long factorial(long number) {
		if (number <= 1) // test for base case
			return 1; // base cases: 0! = 1 and 1! = 1
		else
			// recursion step
			return number * factorial(number - 1);
	}



	//Brute force. Try all n! orderings. Return the schedule with the most profit
	public Schedule bruteForceSolution()
	{	
		Schedule Sc = new Schedule();

		int maxProfit = 0;
		Job[] finalJobs = new Job[jobs.length];

		length = (int) factorial(nJobs);
		bf = new String[length];

		String perm = "";
		//automatically makes the permutation number
		for (int m = 0; m < nJobs; m++) {
			perm = perm + m;
		}

		int firstPermutationDigit = 0;
		permutation(perm);
		int i;


		System.out.println("----------------");


		for(int kk=0; kk < bf.length;kk++){
			//we get each permutation here
			maxProfit = 0;
			int[] temp = new int[jobs.length];

			for(i=0; i < (int) Math.log10(Integer.parseInt(bf[0])) + 1;i++){
				firstPermutationDigit = Integer.parseInt((bf[kk]).substring(i, i+1));
				//we get each digits of each permutation one by one


				for(int ii=0;ii<jobs.length;ii++){
					temp[i] = firstPermutationDigit;
				}
				Job tempJob;

				//We use this for-loop to move the jobs according to sorted list
				for(int j=0; j < temp.length; j++){
					for(int k=j; k < jobs.length; k++){
						if(jobs[k].jobNumber == temp[j]){
							tempJob = jobs[j];
							jobs[j] = jobs[k];
							jobs[k] = tempJob;
							break;
						}
					}
				}
			}



			jobs[0].start = 0;
			jobs[0].finish = jobs[0].length;
			maxProfit = jobs[0].profit;

			int pointer = 1;
			int count = 1;

			while(pointer < jobs.length){

				//this if statement is for when a job is acceptable and we can add its benefit
				if((jobs[count-1].finish+jobs[count].length) <= jobs[count].deadline){

					jobs[count].start = jobs[count-1].finish;
					jobs[count].finish = jobs[count].start + jobs[count].length;

					maxProfit = maxProfit + jobs[count].profit;
					Sc.add(jobs[count]);
					count++;
					pointer++;
				}
				else {
					Job tempJ;
					tempJ = jobs[count];
					for(int k=count+1; k < jobs.length; k++){
						jobs[k-1] = jobs[k];
					}
					jobs[jobs.length-1] = tempJ;
					pointer++;
				}
			}


			if(maxProfit >= Sc.getProfit()){
				Sc.schedule.clear();
				Sc.setBFProfit(maxProfit);


				for(int m=0; m < finalJobs.length; m++){
					finalJobs[m] = jobs[m];
					Sc.add(finalJobs[m]);
				}

			}


			for (int q = count; q < temp.length; q++) {
				Sc.add(jobs[q]);
			}

			while(count < jobs.length){

				jobs[count].start = jobs[count-1].finish;
				jobs[count].finish = jobs[count-1].finish + jobs[count].length;
				count++;
			}
		}

		return Sc;

	}


	public Schedule makeScheduleEDF()
	//earliest deadline first schedule. Schedule items contributing 0 to total profit last
	{

		Schedule Sc = new Schedule();

		int[] temp = new int[jobs.length];
		for(int i=0;i<jobs.length;i++){
			temp[i] = jobs[i].deadline;
		}
		insertionsort(temp);

		Job tempJob;
		for(int j=0; j < temp.length; j++){
			for(int k=j; k < jobs.length; k++){
				if(jobs[k].deadline == temp[j]){
					tempJob = jobs[j];
					jobs[j] = jobs[k];
					jobs[k] = tempJob;
					break;
				}
			}
		}

		jobs[0].start = 0;
		jobs[0].finish = jobs[0].length;
		Sc.add(jobs[0]);
		Sc.setProfit(jobs[0].profit);

		int pointer = 1;
		int count = 1;
		while(pointer < jobs.length){
			if((jobs[count-1].finish+jobs[count].length) <= jobs[count].deadline){

				jobs[count].start = jobs[count-1].finish;
				jobs[count].finish = jobs[count-1].finish + jobs[count].length;
				Sc.setProfit(jobs[count].profit);
				//				System.out.println("Profit is: "+Sc.getProfit());
				Sc.add(jobs[count]);
				count++;
				pointer++;
			}
			else {
				Job tempJ;
				tempJ = jobs[count];
				for(int k=count+1; k < temp.length; k++){
					jobs[k-1] = jobs[k];
				}
				jobs[temp.length-1] = tempJ;
				pointer++;
			}
		}
		for (int q = count; q < temp.length; q++) {
			Sc.add(jobs[q]);
		}

		while(count < jobs.length){

			jobs[count].start = jobs[count-1].finish;
			jobs[count].finish = jobs[count-1].finish + jobs[count].length;
			count++;
		}

		return Sc;
	}


	public Schedule makeScheduleSJF()
	//shortest job first schedule. Schedule items contributing 0 to total profit last
	{
		Schedule Sc = new Schedule();

		int[] temp = new int[jobs.length];
		for(int i=0;i<jobs.length;i++){
			temp[i] = jobs[i].length;
		}
		insertionsort(temp);

		Job tempJob;
		for(int j=0; j < temp.length; j++){
			for(int k=j; k < jobs.length; k++){
				if(jobs[k].length == temp[j]){
					tempJob = jobs[j];
					jobs[j] = jobs[k];
					jobs[k] = tempJob;
					break;
				}
			}
		}


		jobs[0].start = 0;
		jobs[0].finish = jobs[0].length;
		Sc.add(jobs[0]);
		Sc.setProfit(jobs[0].profit);

		int pointer = 1;
		int count = 1;
		while(pointer < jobs.length){
			if((jobs[count-1].finish+jobs[count].length) <= jobs[count].deadline){

				jobs[count].start = jobs[count-1].finish;
				jobs[count].finish = jobs[count-1].finish + jobs[count].length;
				Sc.setProfit(jobs[count].profit);
				Sc.add(jobs[count]);
				count++;
				pointer++;
			}
			else {
				Job tempJ;
				tempJ = jobs[count];
				for(int k=count+1; k < temp.length; k++){
					jobs[k-1] = jobs[k];
				}
				jobs[temp.length-1] = tempJ;
				pointer++;
			}
		}
		for (int q = count; q < temp.length; q++) {
			Sc.add(jobs[q]);
		}


		while(count < jobs.length){

			jobs[count].start = jobs[count-1].finish;
			jobs[count].finish = jobs[count-1].finish + jobs[count].length;
			count++;
		}

		return Sc;
	}

	public Schedule makeScheduleHPF()
	//highest profit first schedule. Schedule items contributing 0 to total profit last
	{
		Schedule Sc = new Schedule();

		int[] temp = new int[jobs.length];
		for(int i=0;i<jobs.length;i++){
			temp[i] = jobs[i].profit;
		}

		insertionsort(temp);

		Job tempJob;
		for(int j=0; j < temp.length; j++){
			for(int k=j; k < jobs.length; k++){
				if(jobs[k].profit == temp[j]){
					tempJob = jobs[j];
					jobs[j] = jobs[k];
					jobs[k] = tempJob;
					break;
				}
			}
		}

		for(int i = 0; i < jobs.length / 2; i++)
		{
			Job tempVal = jobs[i];
			jobs[i] = jobs[jobs.length - i - 1];
			jobs[jobs.length - i - 1] = tempVal;
		}


		jobs[0].start = 0;
		jobs[0].finish = jobs[0].length;
		Sc.setProfit(jobs[0].profit);
		Sc.add(jobs[0]);
		int count = 1;
		int pointer = 1;

		while(pointer< jobs.length){

			if((jobs[count-1].finish+jobs[count].length) <= jobs[count].deadline){


				jobs[count].start = jobs[count-1].finish;
				jobs[count].finish = jobs[count-1].finish + jobs[count].length;
				Sc.setProfit(jobs[count].profit);
				Sc.add(jobs[count]);
				count++;
				pointer++;

			}
			else {

				Job tempJ;
				tempJ = jobs[count];
				for(int k=count+1; k < temp.length; k++){
					jobs[k-1] = jobs[k];
				}
				jobs[temp.length-1] = tempJ;
				pointer++;
			}
		}


		for (int q = count; q < temp.length; q++) {
			Sc.add(jobs[q]);
		}


		while(count < jobs.length){

			jobs[count].start = jobs[count-1].finish;
			jobs[count].finish = jobs[count-1].finish + jobs[count].length;
			count++;
		}

		return Sc;
	}


	public Schedule newApproxSchedule() //Your own creation. Must be <= O(n3)
	{

		Schedule Sc = new Schedule();
		int[] temp = new int[jobs.length];

		//deadline - length for each job
		for(int j=0; j < jobs.length; j++){
			int m = (jobs[j].deadline) - (jobs[j].length);
			jobs[j].start = m;
		}

		//save the temp digit into start time temporary
		for(int i=0;i<jobs.length;i++){
			temp[i] = jobs[i].start;
		}

		insertionsort(temp);

		for(int aa=0; aa < temp.length; aa++){
		}

		Job tempJob;
		for(int j=0; j < temp.length; j++){
			for(int k=j; k < jobs.length; k++){
				if(jobs[k].start == temp[j]){
					tempJob = jobs[j];
					jobs[j] = jobs[k];
					jobs[k] = tempJob;
					break;
				}
			}
		}


		for(int k=0; k < jobs.length; k++){
			jobs[k].start = -1;
		}

		for(int i=0;i<jobs.length;i++){
			if(i==0){
				jobs[0].start = 0;
				jobs[i].finish = jobs[i].length;

			}
			else{
				jobs[i].start = jobs[i-1].finish;
				jobs[i].finish = (jobs[i-1].finish+jobs[i].length);
			}
		}



		jobs[0].start = 0;
		jobs[0].finish = jobs[0].length;
		Sc.add(jobs[0]);
		Sc.setProfit(jobs[0].profit);

		int pointer = 1;
		int count = 1;
		while(pointer < jobs.length){
			if((jobs[count-1].finish+jobs[count].length) <= jobs[count].deadline){


				jobs[count].start = jobs[count-1].finish;
				jobs[count].finish = jobs[count-1].finish + jobs[count].length;
				Sc.setProfit(jobs[count].profit);
				Sc.add(jobs[count]);
				count++;
				pointer++;
			}
			else {
				Job tempJ;
				tempJ = jobs[count];
				for(int k=count+1; k < temp.length; k++){
					jobs[k-1] = jobs[k];
				}
				jobs[temp.length-1] = tempJ;
				pointer++;
			}
		}
		for (int q = count; q < temp.length; q++) {
			Sc.add(jobs[q]);
		}

		while(count < jobs.length){

			jobs[count].start = jobs[count-1].finish;
			jobs[count].finish = jobs[count-1].finish + jobs[count].length;
			count++;
		}

		return Sc;
	}

	public static void insertionsort( int[] a)
	{
		int t = 0;
		int n;
		for(int i = 1 ; i < a.length; i++)
		{
			t = a[i];
			n = i;
			while((n >= 1) && (t < a[n - 1]))
			{
				a[n] = a[n - 1];
				n--;
			}
			a[n] = t;
		}
	}
        
        public void printJobs()  //prints the array jobs
	{
		for (int i = 0; i < nJobs; i++) {
			System.out.println(jobs[i].toString());
		}
	}



}//end of JobScheduler class




//----------------------------------------------------
class Job
{
	int jobNumber;
	int length;
	int deadline;
	int profit;
	int start;
	int finish;


	public Job( int jn , int len, int d, int p)
	{
		jobNumber = jn; length = len; deadline = d;
		profit = p;  start = -1;  finish = -1;
	}


	public String toString()
	{
		return "#" + jobNumber + ":(" + length + ","
				+ deadline + "," + profit +
				"," + start + "," + finish + ")";
	}


}//end of Job class



// ----------------------------------------------------
class Schedule
{
	ArrayList<Job> schedule;
	int profit;

	public Schedule()
	{
		profit = 0;
		schedule = new ArrayList<Job>();
	}

	public void add(Job job)
	{
		schedule.add(job);
	}


	public int getProfit()
	{
		return profit;
	}

	public void setProfit(int p)
	{
		profit = profit + p;
	}

	public void setBFProfit(int p)
	{
		profit = p;
	}

	public String toString()
	{
		String s = "Schedule Profit = " + profit;
		for(int k = 0 ; k < schedule.size(); k++)
		{
			s = s + "\n"  + schedule.get(k);

		}

		return s;
	}



}// end of Schedule class
