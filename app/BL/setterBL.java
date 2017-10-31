package BL;

import DB.getterDB;
import DB.setterDB;
import Entity.*;
import File.FileSetter;
import com.fasterxml.jackson.databind.JsonNode;
import play.mvc.Http;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * @author Yaacov
 */
public class setterBL {
    private setterDB setterDB = new setterDB();
    private getterDB getterDB = new getterDB();
    private BL.getterBL getterBL = new getterBL();
    private FileSetter fileSetter = new FileSetter();
    private WebResponce webResponce = new WebResponce();
    private mailBL mailBl = new mailBL();

    /**
     * Registering a new user into the system.
     *
     * @param szUserName
     * @param szTelephone
     * @param szEmail
     * @param szPassword
     * @return
     * @throws Exception
     */
    public boolean registerNewUser(String szUserName, String szTelephone,
                                   String szEmail, String szPassword, String szPermissionManager, String szPermissionView) throws Exception {
        // INFO
        play.Logger.info("<BUISNESS_LOGIC> Register new user : ");
        play.Logger.info("============================");
        play.Logger.info("For : =>>");
        play.Logger.info("User name : " + szUserName);
        play.Logger.info("Telephone : " + szTelephone);
        play.Logger.info("Email : " + szEmail);
        play.Logger.info("Password : " + szPassword);
        play.Logger.info("============================");
        int nPermissionManager = Integer.parseInt(szPermissionManager);
        int nPermissionView = Integer.parseInt(szPermissionView);
        boolean isRegitred = false;
        if (setterDB.registerNewUser(szUserName, szTelephone, szEmail, szPassword, nPermissionManager, nPermissionView)) {
            isRegitred = true;
        }
        return isRegitred;
    }

    /**
     * Registering a new user into the system.
     *
     * @param szUserName
     * @param szTelephone
     * @param szEmail
     * @param szPassword
     * @return
     * @throws Exception
     */
    public WebResponce addNewUser(String szUserName, String szTelephone, String szEmail, String szPassword, String szPermissionManager, String szPermissionView) throws Exception {
        webResponce = new WebResponce();
        // INFO
        play.Logger.info("<BUISNESS_LOGIC> Register new user : ");
        play.Logger.info("============================");
        play.Logger.info("For : =>>");
        play.Logger.info("User name : " + szUserName);
        play.Logger.info("Telephone : " + szTelephone);
        play.Logger.info("Email : " + szEmail);
        play.Logger.info("Password : " + szPassword);
        play.Logger.info("============================");
        int nPermissionManager = Integer.parseInt(szPermissionManager);
        int nPermissionView = Integer.parseInt(szPermissionView);
        webResponce = setterDB.addNewUser(szUserName, szTelephone, szEmail, szPassword, nPermissionManager, nPermissionView);
        return webResponce;
    }


    private ArrayList<HousePermitedToView> getArrayListOfHousePermissionToView(Iterator<JsonNode> lsthousePermitedToViews) {
        ArrayList<HousePermitedToView> lstHousePermitedToViewsToReturn = new ArrayList<>();
        HousePermitedToView housePermitedToView = new HousePermitedToView();
        JsonNode currJsonNode = null;
        if (lsthousePermitedToViews.hasNext()) {
            currJsonNode = lsthousePermitedToViews.next();
        }
        while (currJsonNode != null) {
            lstHousePermitedToViewsToReturn.add(new HousePermitedToView(currJsonNode.findPath("houseId").asInt(), currJsonNode.findPath("houseAdress").textValue(), currJsonNode.findPath("isPermitedToView").asBoolean()));
            if (lsthousePermitedToViews.hasNext()) {
                currJsonNode = lsthousePermitedToViews.next();
            } else {
                currJsonNode = null;
            }
        }
        return lstHousePermitedToViewsToReturn;
    }

    public WebResponce deleteUser(User m_user) {
        int nUserId = Integer.parseInt(m_user.getUserId());
        webResponce = setterDB.deleteUser(nUserId);
        return webResponce;
    }

    public WebResponce updateHouse(House m_house) {
        webResponce = new WebResponce();
        webResponce.setReason("The house was update In the System. הבית עודכן בהצלחה");
        setterDB.updateHouseDetails(m_house);
        return webResponce;
    }


    public WebResponce insertNewFood(FoodEntity m_foodEntity, List<Http.MultipartFormData.FilePart> foodPictures) throws IOException {
        webResponce = new WebResponce();
        int nFoodIdToReturn = -1;

        // insert data to data base
        webResponce = setterDB.insertNewFood(m_foodEntity);

        // insert pictures files
        nFoodIdToReturn = getterDB.getFoodIdByName(m_foodEntity.getFoodName());

        if (nFoodIdToReturn != -1) {
            saveFoodFiles(foodPictures, nFoodIdToReturn);
        }

        return webResponce;
    }

    public WebResponce insertNewProduct(Product m_productEntity, List<Http.MultipartFormData.FilePart> foodPictures) throws IOException {
        webResponce = new WebResponce();
        int nFoodIdToReturn = -1;

        // insert data to data base
        webResponce = setterDB.insertNewProduct(m_productEntity);

        // insert pictures files
        nFoodIdToReturn = getterDB.getProductIdByName(m_productEntity.getProductName());

        if (nFoodIdToReturn != -1) {
            saveFoodFiles(foodPictures, nFoodIdToReturn);
        }

        return webResponce;
    }

    private void saveFoodFiles(List<Http.MultipartFormData.FilePart> foodPictures, int nFoodIdToReturn) throws IOException {
        int nSumOfFileCounter = 0;
        ArrayList<File> foodPicturesToSave = new ArrayList<>();
        for (Http.MultipartFormData.FilePart currFile : foodPictures) {
            String dstFileName = null;
            if (nSumOfFileCounter == 0) {
                dstFileName = System.getenv("WEBUY_PICTS") + "\\" + nFoodIdToReturn + fileSetter.getTypeFile(currFile.getFilename());
            } else {
                dstFileName = System.getenv("WEBUY_PICTS") + "\\" + nFoodIdToReturn + "_" + String.valueOf(nSumOfFileCounter) + fileSetter.getTypeFile(currFile.getFilename());
            }
            fileSetter.saveToFile(currFile.getFile(), dstFileName, fileSetter.getTypeFile(currFile.getFilename()));
            nSumOfFileCounter++;
        }
    }


    public WebResponce updateUser(String sUserId, String userName, String telephone, String email, String password, String sPermissionManager, String sPermissionView, Iterator<JsonNode> lsthousePermitedToViewsAsJsonNode) throws Exception {
        webResponce = new WebResponce();
        ArrayList<House> houses = getterDB.getListOfHouse();
        ArrayList<HousePermitedToView> lstHousePermitedToViewsFromClient = getArrayListOfHousePermissionToView(lsthousePermitedToViewsAsJsonNode);
        int nUserId = Integer.parseInt(sUserId);

        ArrayList<House> lstHousePermitedToViewFromServer = getterDB.getHouseesAdressPermitedByUserId(nUserId);

        // Looping over list from client
        for (HousePermitedToView currentHouseFromClient : lstHousePermitedToViewsFromClient) {
            boolean bPermissionWasFounded = false;

            // In the case that is a false flag that is mean that the manager want to delete the permission
            if (currentHouseFromClient.getIsPermitedToView() == false) {
                // Looping over the permission list from server
                for (House currentHouseFromServer : lstHousePermitedToViewFromServer) {
                    // When the house was founded we need to delete because is a false flag the manager want to delete the permission
                    if (currentHouseFromServer.getHouseId() == currentHouseFromClient.getHouseId()) {
                        // Delete the permission
                        setterDB.deletePermitedToView(nUserId, currentHouseFromServer.getHouseId());
                    }
                }
            } else if (currentHouseFromClient.getIsPermitedToView() == true) {
                // Looping over the permission list from server
                for (House currentHouseFromServer : lstHousePermitedToViewFromServer) {
                    // We check If The permission Already exist in the server
                    if (currentHouseFromServer.getHouseId() == currentHouseFromClient.getHouseId()) {
                        bPermissionWasFounded = true;
                    }
                }
                // The permission was'nt founded so we need to add
                if (bPermissionWasFounded == false) {
                    // Adding the new permission
                    setterDB.addNewPremitedToView(nUserId, currentHouseFromClient.getHouseId());
                }
            }
        }

        int nPermissionManager = Integer.parseInt(sPermissionManager);
        int nPermissionView = Integer.parseInt(sPermissionView);
        webResponce = setterDB.updateUser(nUserId, userName, telephone, email, password, nPermissionManager, nPermissionView);
        return webResponce;
    }


}
