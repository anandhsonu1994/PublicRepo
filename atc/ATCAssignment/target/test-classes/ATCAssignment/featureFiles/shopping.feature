Feature: Shopping

Scenario: Login, Add Address, Shop and sign out
	Given Login into the application
	And Navigate to 'My Addresses' and add a new address
	And Fill all the informations(not only the mandatory)
	And Click 'Save'
	And Navigate to 'Women' --> Summer dresses
	And The Items would be in 'Grid view'. Change it to 'List View'.
	And Click on the first item to view.
	And Increase the quantity to 5
	And Change the size to 'L'
	And Select any colour. 
	And Add to cart
	And Click 'Continue shopping' and repeat the same for the other 2 items as well under the summer dresses.
	And Proceed to checkout and complete the payment
	And Move to your profile and check 'order history and details'
	When Capture screenshot of the order history
	Then Sign out from the application 