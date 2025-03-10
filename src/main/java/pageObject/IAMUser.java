package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class IAMUser extends BasePage {

	public IAMUser(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@id='headlessui-popover-button-:r0:']")
	WebElement nine_dots;
	
	@FindBy(css="[class='mt-2']>div")
	List<WebElement> neokred_essential;
	
	@FindBy(xpath="//li[@id='users']/button")
	WebElement tab_users;
	
	@FindBy(xpath="//li[@id='groups']/button")
	WebElement tab_groups;
	
	@FindBy(xpath="//button[@id='users_addNewUsersBtn']")
	WebElement add_user;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement first_name;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement last_name;
	
	@FindBy(xpath="//input[@id='designation']")
	WebElement designation;
	
	
	@FindBy(xpath="//input[@id='mobileNumber']")
	WebElement mobile_number;
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	
	@FindBy(xpath="//input[@id='employeeCode']")
	WebElement employee_code;
	
	
	@FindBy(xpath="//input[@placeholder='Select']")
	WebElement drop_down;
	
	
	@FindBy(xpath="//div[@id='searchableDropDown']/div[2]/ul/li[1]")
	WebElement bcrm_user;
	
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement User_bt_next;
	
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement User_bt_cancel;
	
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement password_next;
	
	
	@FindBy(xpath="(//input[@type='checkbox'])[1]")
	WebElement user_delete_checkbox;
	
	@FindBy(xpath="//button[@id='users_deleteUser']")
	WebElement bt_users_deleteUser;
	
	@FindBy(xpath="//div[@class='pt-10 flex justify-between']/button[2]")
	WebElement bt_users_deleteUserConfirm;
	
	@FindBy(xpath="//div[@id='users_usersTable']/div/div/div/div[2]/div/div[2]/table/thead/following-sibling::tbody/tr[1]/td[2]")
	WebElement first_userIntable;
	
	@FindBy(xpath="//button[@id='users_updateUser']")
	WebElement bt_updateUser;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement txt_update_UserFirstname;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement txt_update_UserLastname;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txt_update_UserEmail;
	
	@FindBy(xpath="//button[text()='Confirm']")
	WebElement bt_Update_Confirm;
	
	@FindBy(xpath="//button[@id='users_deleteUser']")
	WebElement bt_update_delete;
	
	@FindBy(xpath="//button[@id='groups_createNewGroupBtn']")
	WebElement bt_createNewGroup;
	
	@FindBy(xpath="//input[@id='groupName']")
	WebElement txt_groupName;
	
	@FindBy(xpath="//button[text()='Confirm']")
	WebElement bt_groupConfirm;
	
	@FindBy(xpath="//button[@id='groups_updateGroupBtn']")
	WebElement bt_UpdateGroup;
	
	@FindBy(xpath="//button[@id='groups_deleteGroupBtn']")
	WebElement bt_deleteGroup;
	
	@FindBy(xpath="//div[@class='pt-10 flex justify-between']/button[2]")
	WebElement bt_confirmDelete;
	
	@FindBy(xpath="//button[@id='groups_addUsersToGroupBtn']")
	WebElement bt_addUser_group;
	
	@FindBy(xpath="//div[@id='groups_addUsersTable']/div/div/div/div[2]/div/div[2]/table/thead/tr/th/div/div/div/input")
	WebElement checkbox_addUserTable;
	
	@FindBy(xpath="//button[text()='Add Users']")
	WebElement bt_addUserInGroup;
	
	@FindBy(xpath="//div[@id='groups_groupPermSummaryDetails']/div[4]/button[2]")
	WebElement bt_addUserIngroupConfirm;
	
	@FindBy(xpath="//div[@id='groups_addUsersTable']/div/div/div/div[2]/div/div[2]/table/tbody/tr/td/div/div/input")
	WebElement check_box_signle_AdduserGroup;
	
	@FindBy(xpath="//button[@id='headlessui-tabs-tab-:r1g:']")
	WebElement bt_policies_InUser;
	
	@FindBy(xpath="//button[@id='users_addPermissionToUserBtn']")
	WebElement bt_addPermissions;
	
	@FindBy(xpath="//div[@class='flex gap-6 md:flex-row']/div[2]/div/div[1]/div/input")
	WebElement bt_radio_AttachPolicyDirectly;
	
	@FindBy(xpath="//div[@id='users_userPoliciesTable']/div/div/div/div[2]/div/div[2]/table/tbody/tr[1]/td/div/div/input")
	WebElement policy_table;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement bt_add_policy_next;
	
	@FindBy(xpath="(//button[text()='Next'])[2]")
	WebElement bt_confirm_Policy_next;
	
	@FindBy(xpath="//div[@id='headlessui-popover-panel-:r3:']/div")
	WebElement frame_navigation;
	
	public WebElement Users()
	{
		return tab_users;
	}
	public WebElement AddUser()
	{
		return add_user;
	}
	public WebElement FirstName()
	{
		return first_name;
	}
	public WebElement LastName()
	{
		return last_name;
	}
	public WebElement Designation()
	{
		return designation;
	}
	public WebElement MobileNumber()
	{
		return mobile_number;
	}
	public WebElement Email()
	{
		return email;
	}
	public WebElement EmployeeCode()
	{
		return employee_code;
	}
	public WebElement SelectRoleDropDown()
	{
		return drop_down;
	}
	public WebElement BCRMUser()
	{
		return bcrm_user;
	}
	
	public WebElement UserNext()
	{
		return User_bt_next;
	}
	public WebElement Cancel()
	{
		return User_bt_cancel;
	}
	public WebElement Password()
	{
		return password;
	}
	public WebElement PasswordNext()
	{
		return password_next;
	}
	public WebElement Checkbox()
	{
		return user_delete_checkbox;
	}
	public WebElement DeleteUser()
	{
		return bt_users_deleteUser;
	}
	public WebElement DeleteUserConfirm()
	{
		return bt_users_deleteUserConfirm;
	}
	public WebElement SelectUserInTable()
	{
		return first_userIntable;
	}
	public WebElement EditUser()
	{
		return bt_updateUser;
	}
	public WebElement UpdateFirstName()
	{
		return txt_update_UserFirstname;
	}
	public WebElement UpdateLastName()
	{
		return txt_update_UserLastname;
	}
	public WebElement UpdateConfirm()
	{
		return bt_Update_Confirm;
	}
	public WebElement UpdateUserDelete()
	{
		return bt_update_delete;
	}
	public WebElement Groups()
	{
		return tab_groups;
	}
	public WebElement CreateNewGroup()
	{
		return bt_createNewGroup;
	}
	public WebElement GroupName()
	{
		return txt_groupName;
	}
	public WebElement GroupConfirm()
	{
		return bt_groupConfirm;
	}
	public WebElement EditGroup()
	{
		return bt_UpdateGroup;
	}
	public WebElement DeleteGroup()
	{
		return bt_deleteGroup;
	}
	public WebElement ConfirmDeleteGroup()
	{
		return bt_confirmDelete;
	}
	public WebElement AdduserGroup()
	{
		return bt_addUser_group;
	}
	public WebElement SelectUSerInAddUsertable()
	{
		return checkbox_addUserTable;
	}
	public WebElement AdduserInGroup()
	{
		return bt_addUserInGroup;
	}
	public WebElement AdduserInGroupConfirm()
	{
		return bt_addUserIngroupConfirm;
	}
	public WebElement AddsingleUserInGroup()
	{
		return check_box_signle_AdduserGroup;
	}
	public WebElement NineDots()
	{
		return nine_dots;
	}
	public List<WebElement> Essential()
	{
		return neokred_essential;
	}
	public WebElement PoliceForUser()
	{
		return bt_policies_InUser;
	}
	public WebElement AddPermission()
	{
		return bt_addPermissions;
	}
	public WebElement AttachPolicyDirectly()
	{
		return bt_radio_AttachPolicyDirectly;
	}
	public WebElement SelectPolicyInTable()
	{
		return policy_table;
	}
	public WebElement AddPolicyNext()
	{
		return bt_add_policy_next;
	}
	public WebElement ConfirmPolicyNext()
	{
		return bt_confirm_Policy_next;
	}
	public WebElement Frame()
	{
		return frame_navigation;
	}
}
