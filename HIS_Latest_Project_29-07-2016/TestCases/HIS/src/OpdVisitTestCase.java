import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpdVisitTestCase extends BaseTestCase {

	public static final int SUCCESS_STATUS_CODE = 200;

	public String pid, visitid;

	/**
	 * This test case is to add Visit
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception of some sort has occurred. This
	 *             class is the general class of exceptions produced by failed
	 *             or interrupted I/O operations.
	 * @throws JSONException
	 *             Exception throws when process Json
	 */
	@Test(groups = "his.lab.test")
	public void addOpdVisitTestCase() throws IOException, JSONException {

		ArrayList<String> resArrayList = getHTTPResponse(
				properties
						.getProperty(TestCaseConstants.URL_APPEND_ADD_OPD_VISIT),
				TestCaseConstants.HTTP_POST, RequestUtil
						.requestByID(TestCaseConstants.ADD_OPD_VISIT));

		pid = (new JSONObject(
				RequestUtil.requestByID(TestCaseConstants.ADD_OPD_VISIT)))
				.getString("pid");

		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)),
				SUCCESS_STATUS_CODE);

	}

	/**
	 * This test case is to update Visit
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception of some sort has occurred. This
	 *             class is the general class of exceptions produced by failed
	 *             or interrupted I/O operations.
	 * @throws JSONException
	 *             Exception throws when process Json
	 */
	@Test(groups = "his.lab.test", dependsOnMethods = { "addOpdVisitTestCase", "getOpdVisitTestRequestByPID" })
	public void updateVisitTestCase() throws IOException, JSONException {

		// Get JSON Request body to send visit update Request
		JSONObject jsonResponseObject = new JSONObject(
				RequestUtil.requestByID(TestCaseConstants.UPDATE_OPD_VISIT));

		System.out.println("visitId =" + visitid);
		jsonResponseObject.put("visitid", visitid);

		// Send JSON Update visit Request
		ArrayList<String> resArrayList = getHTTPResponse(
				properties
						.getProperty(TestCaseConstants.URL_APPEND_UPDATE_OPD_VISIT),
				TestCaseConstants.HTTP_PUT, jsonResponseObject.toString());

		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)),
				SUCCESS_STATUS_CODE);

	}

	/**
	 * This test case is for get Opd request by Patient ID
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception of some sort has occurred. This
	 *             class is the general class of exceptions produced by failed
	 *             or interrupted I/O operations.
	 * @throws JSONException
	 *             Exception throws when process Json
	 */
	@Test(groups = "his.lab.test", dependsOnMethods = { "addOpdVisitTestCase" })
	public void getOpdVisitTestRequestByPID() throws IOException, JSONException {

		ArrayList<String> resArrayList = getHTTPResponse(
				properties
						.getProperty(TestCaseConstants.URL_APPEND_OPD_VISIT_BY_PID)
						+ (new JSONObject(RequestUtil
								.requestByID(TestCaseConstants.ADD_OPD_VISIT))
								.getString("pid")),
				TestCaseConstants.HTTP_GET, null);

		JSONArray jsonArray = new JSONArray(resArrayList.get(0));

		
		int visitId=-1;
		
		for(int i=0; i<jsonArray.length()-1; i++)
		{
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			
			if(visitId < jsonObj.getInt("visitID"))
			{
				visitId = jsonObj.getInt("visitID");
			}
		}
		
		// System.out.println(jsonObject);
		visitid = visitId + "";

		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)),
				SUCCESS_STATUS_CODE);

	}

	/**
	 * This test case is for get Opd request by Patient ID
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception of some sort has occurred. This
	 *             class is the general class of exceptions produced by failed
	 *             or interrupted I/O operations.
	 * @throws JSONException
	 *             Exception throws when process Json
	 */
	@Test(groups = "his.lab.test", dependsOnMethods = { "addOpdVisitTestCase" })
	public void getOpdVisitRecentRequestByPID() throws IOException,
			JSONException {

		ArrayList<String> resArrayList = getHTTPResponse(
				properties
						.getProperty(TestCaseConstants.URL_APPEND_OPD_VISIT_RECENT_BY_PID)
						+ (new JSONObject(RequestUtil
								.requestByID(TestCaseConstants.ADD_OPD_VISIT))
								.getString("pid")),
				TestCaseConstants.HTTP_GET, null);

		JSONArray jsonArray = new JSONArray(resArrayList.get(0));
		JSONObject jsonObject = ((JSONObject) jsonArray
				.get(jsonArray.length() - 1));
		visitid = jsonObject.getString("visitID");

		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)),
				SUCCESS_STATUS_CODE);

	}

	/**
	 * This test case is for get Opd request by Visit Date
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception of some sort has occurred. This
	 *             class is the general class of exceptions produced by failed
	 *             or interrupted I/O operations.
	 * @throws JSONException
	 *             Exception throws when process Json
	 */
	@Test(groups = "his.lab.test", dependsOnMethods = { "addOpdVisitTestCase",
			"getOpdVisitTestRequestByPID" })
	public void getOpdVisitTestRequestByVisitDate() throws IOException,
			JSONException {

		String url = new JSONObject(
				RequestUtil.requestByID(TestCaseConstants.ADD_OPD_VISIT))
				.getString("DateandTime");
		String encodedURL = java.net.URLEncoder.encode(url, "UTF-8");
		ArrayList<String> resArrayList = getHTTPResponse(
				properties.getProperty(TestCaseConstants.URL_APPEND_OPD_VISIT_BY_VISITDATE)
						+ encodedURL, TestCaseConstants.HTTP_GET, null);

		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)),
				SUCCESS_STATUS_CODE);

	}

	/**
	 * This test case is for get Opd request IDs
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception of some sort has occurred. This
	 *             class is the general class of exceptions produced by failed
	 *             or interrupted I/O operations.
	 * @throws JSONException
	 *             Exception throws when process Json
	 */
	@Test(groups = "his.lab.test", dependsOnMethods = { "addOpdVisitTestCase",
			"getOpdVisitTestRequestByPID" })
	public void getOpdVisitForReports() throws IOException, JSONException {

		String url1 = new JSONObject(
				RequestUtil.requestByID(TestCaseConstants.ADD_OPD_VISIT))
				.getString("DateandTime");
		String encodedURL = java.net.URLEncoder.encode(url1, "UTF-8");

		String url2 = new JSONObject(
				RequestUtil.requestByID(TestCaseConstants.ADD_OPD_VISIT))
				.getString("toDate");
		String encodedURL2 = java.net.URLEncoder.encode(url2, "UTF-8");

		System.out
				.println(properties
						.getProperty(TestCaseConstants.URL_APPEND_OPD_VISIT_FOR_REPORTS)
						+ encodedURL
						+ "/"
						+ encodedURL2
						+ "/"
						+ new JSONObject(RequestUtil
								.requestByID(TestCaseConstants.ADD_OPD_VISIT))
								.getString("Doctor"));

		ArrayList<String> resArrayList = getHTTPResponse(
				properties
						.getProperty(TestCaseConstants.URL_APPEND_OPD_VISIT_FOR_REPORTS)
						+ encodedURL
						+ "/"
						+ encodedURL2
						+ "/"
						+ new JSONObject(RequestUtil
								.requestByID(TestCaseConstants.ADD_OPD_VISIT))
								.getString("Doctor"),
				TestCaseConstants.HTTP_GET, null);

		System.out.println(resArrayList.get(0));

		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)),
				SUCCESS_STATUS_CODE);

	}

	/**
	 * This test case is for get Opd request by Visit ID
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception of some sort has occurred. This
	 *             class is the general class of exceptions produced by failed
	 *             or interrupted I/O operations.
	 * @throws JSONException
	 *             Exception throws when process Json
	 */
	@Test(groups = "his.lab.test", dependsOnMethods = { "addOpdVisitTestCase",
			"getOpdVisitTestRequestByPID", "updateVisitTestCase" })
	public void getOpdVisitTestByVisitId() throws IOException, JSONException {

		ArrayList<String> resArrayList = getHTTPResponse(
				properties.getProperty(TestCaseConstants.URL_APPEND_OPD_VISIT_BY_VISITID)
						+ visitid, TestCaseConstants.HTTP_GET, null);

		JSONArray jsonArray = new JSONArray(resArrayList.get(0));
		JSONObject jsonObject = ((JSONObject) jsonArray
				.get(jsonArray.length() - 1));

		System.out.println(jsonObject);
		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)),
				SUCCESS_STATUS_CODE);
		Assert.assertEquals(jsonObject.getString("visitID"), visitid);

	}

}
