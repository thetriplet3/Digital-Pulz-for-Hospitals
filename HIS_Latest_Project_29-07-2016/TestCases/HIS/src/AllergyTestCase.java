import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * This class is for TestNG Integration Test cases related to all
 * functionalities of OPD in HIS Project. developed by Nisal De Silva.
 * 
 * {@link BaseTestCase}
 * @author nisal.d
 * 
 */
public class AllergyTestCase extends BaseTestCase {
  
	public static final int SUCCESS_STATUS_CODE = 200;
	
	public static String allergyId;
	public static String patientId;
	public JSONArray jsonArray;
	
	
	/**
	 * This test case is for add New Allergy
	 * 
	 * @throws IOException
	 */
	@Test(groups = "his.opd.test")
	public void addAllergyTestCase() throws IOException, JSONException {
	
		
		ArrayList<String> resArrayList = getHTTPResponse(
				properties.getProperty(TestCaseConstants.URL_APPEND_ADD_ALLERGY), TestCaseConstants.HTTP_POST,
				RequestUtil.requestByID(TestCaseConstants.URL_APPEND_ADD_ALLERGY));

		//patientId = (new JSONObject(RequestUtil.requestByID(TestCaseConstants.URL_APPEND_ADD_ALLERGY))).getString("pid");
		patientId = resArrayList.get(0);
		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)), SUCCESS_STATUS_CODE);
	}
	
	/**
	 * This test case is to update Allergy
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception of some sort has occurred. This
	 *             class is the general class of exceptions produced by failed
	 *             or interrupted I/O operations.
	 * @throws JSONException
	 *             Exception throws when process Json
	 */
	@Test(groups = "his.opd.test", dependsOnMethods = { "addAllergyTestCase", "getAllergiesByPatientTestCase" })
	public void updateAllergyTestCase() throws IOException, JSONException {

		// Get JSON Request body to send allergy update Request
		JSONObject jsonResponseObject = new JSONObject(RequestUtil.requestByID(TestCaseConstants.URL_APPEND_UPDATE_ALLERGY));
		
		jsonResponseObject.put("allergyid", allergyId);
		
		// Send JSON Update allergy Request
		ArrayList<String> resArrayList = getHTTPResponse(
				properties.getProperty(TestCaseConstants.URL_APPEND_UPDATE_ALLERGY), TestCaseConstants.HTTP_PUT,
				jsonResponseObject.toString());

		

		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)), SUCCESS_STATUS_CODE);

	}
	
	/**
	 * This test case is for get allergy by patient ID
	 * 
	 * @throws IOException
	 * @throws JSONException 
	 */
	@Test(groups = "his.opd.test", dependsOnMethods = { "addAllergyTestCase"})
	public void getAllergiesByPatientTestCase() throws IOException, JSONException{

		ArrayList<String> resArrayList = getHTTPResponse(properties.getProperty(TestCaseConstants.URL_APPEND_GET_ALLERGY_BY_PATIENT)+patientId,
				TestCaseConstants.HTTP_GET, null);
		
		jsonArray = new JSONArray(resArrayList.get(0));
		
		JSONObject jsonObject = new JSONObject(RequestUtil.requestByID(TestCaseConstants.URL_APPEND_UPDATE_ALLERGY));
		JSONObject jsonObject2 = jsonArray.getJSONObject(jsonArray.length()-1);
		
		System.out.println(jsonArray.getJSONObject(jsonArray.length()-1));
		allergyId = (jsonArray.getJSONObject(jsonArray.length() - 1)).getString("allergyID");
		System.out.println("allergyId = "+ allergyId);
		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)), SUCCESS_STATUS_CODE);
		Assert.assertEquals(jsonObject2.getString("allergyName"),jsonObject.getString("name"));
	}
	
	/**
	 * This test case is for get allergy by allergy ID
	 * 
	 * @throws IOException
	 * @throws JSONException 
	 */
	@Test(groups = "his.opd.test", dependsOnMethods = { "addAllergyTestCase", "getAllergiesByPatientTestCase", "updateAllergyTestCase"})
	public void getAllergiesByAllergyIdTestCase() throws IOException, JSONException{

		ArrayList<String> resArrayList = getHTTPResponse(properties.getProperty(TestCaseConstants.URL_APPEND_GET_ALLERGY_BY_ID)+allergyId,
				TestCaseConstants.HTTP_GET, null);
		
		JSONObject jsonObject = new JSONObject(RequestUtil.requestByID(TestCaseConstants.URL_APPEND_UPDATE_ALLERGY));
		
		jsonArray = new JSONArray(resArrayList.get(0));
		JSONObject jsonObject2 = jsonArray.getJSONObject(jsonArray.length()-1);
		
		
		Assert.assertEquals(Integer.parseInt(resArrayList.get(1)), SUCCESS_STATUS_CODE);
		Assert.assertEquals(jsonObject2.getString("allergyRemarks"), jsonObject.getString("remarks"));
	}
}
