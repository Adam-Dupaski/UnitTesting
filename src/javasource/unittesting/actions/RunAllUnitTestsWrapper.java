// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package unittesting.actions;

import org.apache.commons.lang3.exception.ExceptionUtils;
import unittesting.TestManager;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

public class RunAllUnitTestsWrapper extends CustomJavaAction<Boolean>
{
	private IMendixObject __testRun;
	private unittesting.proxies.TestSuite testRun;

	public RunAllUnitTestsWrapper(IContext context, IMendixObject testRun)
	{
		super(context);
		this.__testRun = testRun;
	}

	@Override
	public Boolean executeAction() throws Exception
	{
		this.testRun = __testRun == null ? null : unittesting.proxies.TestSuite.initialize(getContext(), __testRun);

		// BEGIN USER CODE
		try {
			//Run tests in a new context without transaction!
			TestManager.instance().runTestSuite(Core.createSystemContext(), testRun);
		}
		catch(Exception e) {
			TestManager.LOG.error("An error occurred while trying to run the unit tests: " + ExceptionUtils.getRootCauseMessage(e), e);
			return false;
		}
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "RunAllUnitTestsWrapper";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
