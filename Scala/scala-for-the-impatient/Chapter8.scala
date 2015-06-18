class BankAccount(initialBalance: Double) {
    
    private var balance = initialBalance
        def currentBalance = balance
        def deposit(amount: Double) = { balance += amount; balance }
        def withdraw(amount: Double) = { balance -= amount; balance }
    }

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
    val MONTHLY_INTEREST = 0.1

    var freeActions = 0

    override def deposit(amount: Double) = {
        freeActions += 1
        super.deposit(if (freeActions > 3) amount-1 else amount)
         
    }

    override def withdraw(amount: Double) = {
        freeActions += 1
        super.withdraw(if (freeActions > 3) amount+1 else amount)
            
    }

    def earnMonthlyInterest() = {
        super.deposit(MONTHLY_INTEREST * currentBalance)
        freeActions = 0
        currentBalance
    }
}