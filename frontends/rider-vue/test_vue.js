const {Builder, By} = require('selenium-webdriver');

(async function example() {
  let driver = await new Builder().forBrowser('chrome').build();
  try {
    await driver.get('http://localhost:8080');
    await (await driver.findElement(By.id('login-btn'))).click();
  } finally {
    // await driver.quit();
  }
})();