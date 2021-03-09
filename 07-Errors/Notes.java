public class Notes {

    // 1. USAR EXCEPCIONES EN LUGAR DE CÓDIGOS DE ERROR

    public void createEnemy(EnemyType type) {
        Enemy enemy = enemySpawner.createEnemy(type);
        if (enemy.status != EnemyStatus.INVALID) {
            addEnemyToPool(enemy);
            if (enemy.status != ERROR_ADDING) {
                activateEnemy(enemy);
                increaseCounter();
                upgradeGlobalStats(enemy);
            } else {
                logger.log("Enemy could not be added to pool: " + type.toString());
            }
        } else {
            logger.log("Enemy could not be created: " + type.toString());
        }
    }

    public void createEnemy(EnemyType type) {
        try {
            tryToCreateEnemy(type);
        } catch (EnemyCreationError e) {
            logger.log(e);
        }
    }

    private void tryToCreateEnemy(EnemyType type) throws EnemyCreationError {
        Enemy enemy = enemySpawner.createEnemy(type);
        addEnemyToPool(enemy);
        activateEnemy(enemy);
        increaseCounter();
        upgradeGlobalStats(enemy);
    }

    private Enemy createEnemy(EnemyType type) {
        throw new EnemyCreationError("Enemy could not be created: " + type);
    }

    // 2. CREAR PRIMERO LA INSTRUCCIÓN TRY-CATCH-FINALLY
    @Test(expected = StorageException.class)
    public void retrieveSectionShouldThrowOnInvalidFileName() {
        sectionStore.retrieveSection("invalid - file");
    }

    public List<RecordedGrip> retrieveSection(String sectionName) {
        // dummy return until we have a real implementation
        return new ArrayList<RecordedGrip>();
    }

    public List<RecordedGrip> retrieveSection(String sectionName) {
        try {
            FileInputStream stream = new FileInputStream(sectionName)
        } catch (Exception e) {
            throw new StorageExce return new ArrayList<RecordedGrip>();
        }
    }

    public List<RecordedGrip> retrieveSection(String sectionName) {
        try {
            FileInputStream stream = new FileInputStream(sectionName);
            stream.close();
        } catch (FileNotFoundException e) {
            throw new StorageException("retrieval error", e);
        }
        return new ArrayList<RecordedGrip>();
    }

    // 3. USAR EXCEPCIONES SIN COMPROBAR
    // https://picodotdev.github.io/blog-bitix/2018/04/la-controversia-sobre-las-excepciones-checked-y-unchecked/

    // 4. OFRECER CONTEXTO JUNTO A LAS EXCEPCIONES

    // 5. DEFINIR CLASES DE EXCEPCION DE ACUERDO A LAS NECESIDADES DEL INVOCADOR
    public void openPort() {
        ACMEPort port = new ACMEPort(12);
        try {
            port.open();
        } catch (DeviceResponseException e) {
            reportPortError(e);
            logger.log("Device response exception", e);
        } catch (ATM1212UnlockedException e) {
            reportPortError(e);
            logger.log("Unlock exception", e);
        } catch (GMXError e) {
            reportPortError(e);
            logger.log("Device response exception");
        } finally {

        }
    }

    public void openPort2() {
        LocalPort port = new LocalPort(12);
        try {
            port.open();
        } catch (PortDeviceFailure e) {
            reportError(e);
            logger.log(e.getMessage(), e);
        } finally {

        }
    }

    public class LocalPort {
        private ACMEPort innerPort;

        public LocalPort(int portNumber) {
            innerPort = new ACMEPort(portNumber);
        }

        public void open() {
            try {
                innerPort.open();
            } catch (DeviceResponseException e) {
                throw new PortDeviceFailure(e);
            } catch (ATM1212UnlockedException e) {
                throw new PortDeviceFailure(e);
            } catch (GMXError e) {
                throw new PortDeviceFailure(e);
            }
        }

    }

    // DEFINIR EL FLUJO NORMAL
    try {
        MealExpenses expenses = expenseReportDAO.getMeals(employee.getID());
        m_total += expenses.getTotal();
    } catch(MealExpensesNotFound e) {
        m_total += getMealPerDiem();
    }

    MealExpenses expenses = expenseReportDAO.getMeals(employee.getID());
    m_total += expenses.getTotal();

    public class PerDiemMealExpenses implements MealExpenses {
        public int getTotal() {
            // return the per diem default
        }
    }


    // NO DEVOLVER NULL
    public void registerItem(Item item) {
        if (item != null) {
            ItemRegistry registry = peristentStore.getItemRegistry();
            if (registry != null) {
                Item existing = registry.getItem(item.getID());
                if (existing.getBillingPeriod().hasRetailOwner()) {
                    existing.register(item);
                }
            }
        }
    }
    List<Employee> employees = getEmployees();
if (employees != null) {
        for(Employee e : employees) {
            totalPay += e.getPay();
        }
    }

    List<Employee> employees = getEmployees();
for(Employee e : employees) {
        totalPay += e.getPay();
    }

    public List<Employee> getEmployees() {
        if( .. there are no employees .. )
        return Collections.emptyList();
    }

    private List<Employee> employees;

    public List<Employee> getEmployees() {
        if( .. there are no employees .. )
        return Collections.emptyList();
    }


    // NO PASAR NULL
    // Buscar información sobre Optionals y la gestión de los nulls con los Optionals

}

