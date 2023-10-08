
# Create an Account

**Goal In Context:** Personal user wishes to create an account

**Pre-condition:** User not registered

**Success:** User creates/owns an account

**Failure:** User does not create account

**Primary Actors:** User

**Secondary Actors:** Credential Database

**Trigger:** User asks system to create account

**Main Flow:**
1. User selects Create Account
2. User fills in create account prompts with personal information/credentials
3. Credentials are checked in the database
4. New account is created and stored in database
5. Confirmation email is sent to user       

**Extensions:**
3.1 Account with email already exists error, account not created

# Create Business Account

**Goal In Context:**  Business user wishes to create account

**Pre-condition:**  User not registered and owns a business

**Success:**  User creates business account

**Failure :**  User does not create business account

**Primary Actors:** User

**Secondary Actors:** Credential Database, Administrator

**Trigger:** User asks system to create account

**Base Usecase**: Create an Account

**Main Flow:**
1. User selects Create Account
2. **User selects create business account**
3. User fills in create account prompts with **business information**/credentials
4. Credentials are checked in database
5. **Admin reviews the information/credentials**
6. **Admin signs off on business account**
7. New account is created and stored in database
8. Confirmation email is sent to user

**Extensions:**
3.1 Account with email already exists error, account not created
3.2 Business licence already in use error, account not created
5.1 Admin does not accept business account, account not created

# Update Account Credentials

**Goal In Context:** User wishes to change account credentials

**Pre-condition:** User already has an account

**Success:** User changes their account credentials

**Failure:** User does not change their account credentials

**Primary Actors:** User

**Secondary Actors:** Credential Database

**Trigger:** User asks system to change account credentials

**Main Flow:**
1. User logs into account
2. User selects profile icon
3. User selects update account
4. User changes the credentials they wish to change
5. User selects save
6. Credentials in database are updated
7. Confirmation email is sent to user

**Extensions:**
5.1 User selects cancel, credentials not updated
5.2 User times out, credentials not updated

## Login

**Goal In Context:** User logs in

**Pre-condition:** User already has an account

**Success:** User logs into account

**Failure:** User does not log into account

**Primary Actors:** User

**Secondary Actors:** Credential Database

**Trigger:** Users asks system to log him in

**Main Flow:**
1. User enters email
2. User enters password
3. Credentials are checked with the database
4. User successfully logs in

**Extensions:**
3.1 Incorrect email or password error, user not logged in

# Recover Password

**Goal In Context:** User wishes to change their password

**Pre-condition:** User already has an account

**Success:** User changes password

**Failure:** User does not change password

**Primary Actors:** User

**Secondary Actors:** Credential Database

**Trigger:** User asks system to update password

**Main Flow:**
1. User selects Forgot Password
2. User enters email
3. System emails an update password link
4. User selects Update Password
5. User enters new password
6. User enters new password again
7. User selects Confirm
8. Password updated in database
9. Confirmation email sent

**Extensions:**
6.1 Users passwords do not match, password not updated
6.2 User selects cancel, password not updated
6.3 User times out, password not updated
