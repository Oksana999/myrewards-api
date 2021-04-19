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

### Usage Examples
Get all payment transaction for user with id=6 for last 180 days:
![image](https://user-images.githubusercontent.com/38441249/115195306-751ed380-a0a3-11eb-8d46-d1cd02064752.png)

Calculate rewards for user with id=3 for last 140 days:
![image](https://user-images.githubusercontent.com/38441249/115195150-4274db00-a0a3-11eb-9ed0-624f4fb14ac5.png)

