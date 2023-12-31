package starter.cookit.ingredients;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.cookit.auth.LoginAPI;
import starter.cookit.recipes.RecipesAPI;
import starter.utils.Constant;

import java.io.File;

public class IngredientsAPI {

    public static String CREATE_NEW_INGREDIENT = Constant.BASE_URL + "/recipes/{recipe_id}/ingredients";

    public static String UPDATE_RECIPES_INGREDIENT = Constant.BASE_URL + "/recipes/{recipe_id}/ingredients/{ingredient_id}";



    @Step("Insert new recipes ingredient with valid recipes_id and valid req body")
    public static void setInsertNewRecipesIngredient(File json) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .body(json);
    }

    @Step("Delete ingredients with valid recipe_id")
    public static void setDeleteIngredientWithValidRecipeId() {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID);
    }

    @Step("Delete ingredients with exceed recipe_id")
    public static void setDeleteIngredientExceedId(String recipeID) {
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipeID);
    }

    @Step("Update ingredient with valid recipe_id, valid ingredient_id and valid body")
    public static void setUpdateIngredientAllValid(File jsonFile) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        String INGREDIENT_ID = GENERAL.getString("data.ingredients[0].id");

        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("ingredient_id", INGREDIENT_ID)
                .body(jsonFile);
    }

    @Step("Update ingredient with exceed recipe_id, valid ingredient_id and valid body")
    public static void setUpdateIngredientExceedRecipeID(String recipeID, File jsonFile) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String INGREDIENT_ID = GENERAL.getString("data.ingredients[0].id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipeID)
                .pathParam("ingredient_id", INGREDIENT_ID)
                .body(jsonFile);
    }

    @Step("Update ingredient with valid recipe_id, exceed ingredient_id and valid body")
    public static void setUpdateIngredientExceedIngredientID(String ingredientID, File jsonFile) {
        String TOKEN = LoginAPI.getUserToken();
        String RECIPE_ID = RecipesAPI.getFirstRecipeId();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("ingredient_id", ingredientID)
                .body(jsonFile);
    }

    @Step("Delete ingredient with all valid param")
    public static void setDeleteIngredientWithAllValidParam() {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        String INGREDIENT_ID = GENERAL.getString("data.ingredients[0].id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("ingredient_id", INGREDIENT_ID);
    }

    @Step("Delete ingredient with exceed recipe_id and valid ingredient_id")
    public static void setDeleteIngredientWithExceedRecipeID(String recipeID) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String INGREDIENT_ID = GENERAL.getString("data.ingredients[0].id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipeID)
                .pathParam("ingredient_id", INGREDIENT_ID);
    }

    @Step("Delete ingredient with valid recipe_id and exceed ingredient_id")
    public static void setDeleteIngredientWithExceedIngredientID(String ingredientID) {
        String TOKEN = LoginAPI.getUserToken();
        JsonPath GENERAL = RecipesAPI.getGeneralDataFromThisFunction();
        String RECIPE_ID = GENERAL.getString("data.id");
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", RECIPE_ID)
                .pathParam("ingredient_id", ingredientID);
    }

    @Step("Delete ingredient with all invalid param alphabet")
    public static void setDeleteIngredientWithAllInvalidParam(String ingredientID, String recipeID) {
        String TOKEN = LoginAPI.getUserToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + TOKEN)
                .contentType(ContentType.JSON)
                .pathParam("recipe_id", recipeID)
                .pathParam("ingredient_id", ingredientID);
    }
}
