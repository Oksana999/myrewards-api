# myrewards-api
Spring Boot Application, provides API access to user rewards calculation.

## Endoints:

### Users

/api/users - for retrieveing user info
* /all - show all users
* /by-id - find user by id
* /by-email - find user by email

### Payments

/api/payments - for retrieveing payments info
* /all - show all payments
* /by-user-id - find payments for selected user
  * /last-n-days - narrow down selection. Select payments for last N days
* /by-user-email - find payments for user with selected email

### Rewards

/api/rewards - for calculating rewards
* /by-user-id/last-n-days - calculate rewards for selected user for last N days
