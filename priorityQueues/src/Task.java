public class Task implements Comparable<Task> {
	
	private String task;
	private char primary;
	private int secondary;
		
	public Task( String task, char primary, int secondary) {
		
		this.task = task;
		this.primary = primary;
		this.secondary = secondary;
	}
	
	public int compareTo( Task otherTask) {
		
		if(this.primary<otherTask.primary)
			return 1;
		if(this.primary == otherTask.primary) {
			if (this.secondary<otherTask.secondary)
				return 1;
		}
		return -1;
	}
	
	public String getTask() {
		
		return this.task;
	}
	
	public char getPrimary() {
		
		return this.primary;
	}
	
	public int getSecondary() {
		
		return this.secondary;
	}
	
	public void setTask( String task) {
		
		if( !task.isEmpty())
			this.task = task;
		
		return;
	}
	
	public void setPrimary( char primary) {
		
		if( primary >= 'A' && primary <= 'Z')
			this.primary = primary;
		
		return;
	}
	
	public void setSecondary( int secondary) {
		
		if( secondary >= 0)
			this.secondary = secondary;
		
		return;
	}
		
	public String toString() {
	
		String str =   + this.primary +""+ this.secondary+": " +this.task;
		
		return( str);
	}

}
