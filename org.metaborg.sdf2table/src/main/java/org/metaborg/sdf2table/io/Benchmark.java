package org.metaborg.sdf2table.io;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Benchmark{
	public static String tabulation(int tab){
		String str = "";
		while(tab > 0){
			str += "...";
			tab -= 1;
		}
		return str;
	}
	
	public static String formatTime(long t){
		String millis = String.valueOf(t%1000);
    	while(millis.length() < 3)
    		millis = "0"+millis;
    	return String.valueOf(t/1000)+"."+millis+"s";
	}
	
	public static abstract class Task{
		String _name;
		
		public Task(String name){
			_name = name;
		}
		
		public String name(){
			return _name;
		}
		
		public abstract long startTime();
		
		public abstract long endTime();
		
		public long duration(){
			return endTime()-startTime();
		}
		
		public abstract void print(PrintStream out, int tab);
	}
	
	public static class SingleTask extends Task{
		private long _start_time;
		private long _end_time;
		
		public SingleTask(String name){
			super(name);
		}
		
		public void start(){
			_start_time = System.currentTimeMillis();
		}
		
		public void stop(){
			_end_time = System.currentTimeMillis();
		}
		
		@Override
		public void print(PrintStream out, int tab){
			if(out == System.err){
				out.println(Benchmark.tabulation(tab)+name()+": "+formatTime(duration()));
			}else{
				out.print(";"+((double)duration()/1000.0));
			}
		}

		@Override
		public long startTime() {
			return _start_time;
		}

		@Override
		public long endTime() {
			return _end_time;
		}
	}
	
	public static class DistributedTask extends Task{
		private long _start_time = -1;
		private long _resume_time = -1;
		private long _end_time = -1;
		private long _duration = 0;
		private int _started = 0;
		
		public DistributedTask(String name){
			super(name);
		}
		
		public void start(){
			++_started;
			if(_started > 1)
				return;
			_resume_time = System.currentTimeMillis();
			if(_start_time == -1)
				_start_time = _resume_time;
		}
		
		public void stop(){
			--_started;
			if(_started > 0)
				return;
			_end_time = System.currentTimeMillis();
			_duration += _end_time - _resume_time;
		}
		
		@Override
		public long duration(){
			return _duration;
		}
		
		@Override
		public void print(PrintStream out, int tab){
			if(out == System.err){
				out.println(Benchmark.tabulation(tab)+" [#] "+name()+": "+formatTime(duration()));
			}else{
				out.print(";"+((double)duration()/1000.0));
			}
		}

		@Override
		public long startTime() {
			return _start_time;
		}

		@Override
		public long endTime() {
			return _end_time;
		}
	}
	
	public static class ComposedTask extends Task{
		List<Task> _sub_task = new LinkedList<>();
		ComposedTask _parent = null;
		
		public ComposedTask(String name){
			super(name);
		}
		
		public void start(){
			_parent = current;
			current = this;
		}
		
		public void stop(){
			current = _parent;
		}
		
		public void reset(){
			_sub_task.clear();
		}
		
		public Task newTask(Task task){
			_sub_task.add(task);
			return task;
		}
		
		public SingleTask newSingleTask(String name){
			SingleTask task = new SingleTask(name);
			_sub_task.add(task);
			return task;
		}
		
		public ComposedTask newComposedTask(String name){
			ComposedTask task = new ComposedTask(name);
			_sub_task.add(task);
			return task;
		}
		
		public DistributedTask newDistributedTask(String name){
			DistributedTask task = new DistributedTask(name);
			_sub_task.add(task);
			return task;
		}
		
		@Override
		public void print(PrintStream out, int tab){
			if(out == System.err){
				out.println(Benchmark.tabulation(tab)+name()+": "+formatTime(duration()));
				for(Task t : _sub_task){
					t.print(out, tab+1);
				}
			}else{
				out.print(";"+((double)duration()/1000.0));
				for(Task t : _sub_task){
					t.print(out, 0);
				}
			}
		}

		@Override
		public long startTime() {
			if(_sub_task.isEmpty())
				return 0;
			return _sub_task.get(0).startTime();
		}

		@Override
		public long endTime() {
			if(_sub_task.isEmpty())
				return 0;
			return _sub_task.get(_sub_task.size()-1).endTime();
		}
	}
	
	public final static ComposedTask main = new ComposedTask("to_parse_table");
	public static ComposedTask current = main;
	
	public static SingleTask newSingleTask(String name){
		return current.newSingleTask(name);
	}
	
	public static ComposedTask newComposedTask(String name){
		return current.newComposedTask(name);
	}
	
	public static DistributedTask newDistributedTask(String name){
		return current.newDistributedTask(name);
	}
	
	public static void reset(){
		main.reset();
		current = main;
	}
	
	public static void print(PrintStream out){
		if(out == System.err){
			out.println("===== benchmark =====");
			main.print(out, 0);
			out.println("=====================");
		}else{
			main.print(out, 0);
		}
	}
	
	public static long printStatistics(String step, long totalTime) {
        String millis = String.valueOf(totalTime % 1000);
        while(millis.length() < 3)
            millis = "0" + millis;
        System.out.println(step + String.valueOf(totalTime / 1000) + "." + millis + "s");
        return totalTime;
    }
}
