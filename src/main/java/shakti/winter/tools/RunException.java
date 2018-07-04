package shakti.winter.tools;

public class RunException extends RuntimeException{

		private static final long serialVersionUID = -4699353209943610311L;

		public RunException(String msg) {
			super(msg);
		}
		
		public RunException(String msg, Throwable th) {
			super(msg, th);
		}

	}

