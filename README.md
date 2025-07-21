# SauceDemo-WebUI-KatalonStudio

![Build Status](https://github.com/devoav1997/SauceDemo-WebUI-KatalonStudio/actions/workflows/main.yml/badge.svg)

Project ini adalah automation test UI untuk https://www.saucedemo.com/ menggunakan **Katalon Studio**.
Struktur dan kode sudah dioptimalkan untuk maintainability, SRP, dan siap integrasi CI/CD.

---

## Struktur Folder

```plaintext
SauceDemo-WebUI/
├── Test Cases/
│   ├── login/
│   │   ├── TC_LoginPositive
│   │   ├── TC_LoginNegative_EmptyPassword
│   │   ├── TC_LoginNegative_EmptyUsername
│   │   ├── TC_LoginNegative_EmptyUsernameAndPassword
│   │   ├── TC_LoginNegative_InvalidUsernamePassword
│   │   ├── TC_LoginNegative_InvalidUsername_ValidPassword
│   │   └── TC_LoginNegative_ValidUsername_InvalidPassword
│   ├── cart/
│   │   ├── TC_AddToCart_Positive
│   │   ├── TC_RemoveFromCart_Positive
│   │   ├── TC_AddToCart_Negative_ItemNotExist
│   │   └── TC_RemoveFromCart_Negative_CartEmpty
│   └── checkout/
│       ├── TC_CheckoutHappyPath
│       ├── TC_CheckoutMissingInfo
│       ├── TC_CheckoutMissingZip
│       └── TC_CheckoutMissingLastName
├── Test Suites/
│   └── SmokeSuite
├── Object Repository/
├── Keywords/
│   ├── login/
│   │   └── LoginLocators.groovy
│   ├── cart/
│   │   └── CartLocators.groovy
│   └── checkout/
│       └── CheckoutLocators.groovy
├── Profiles/
│   └── default.glbl
├── Test Listeners/
│   └── LoggingListener.groovy
├── .gitignore
└── README.md
````

---

## Kenapa Locator Dipisah per Modul?

* **Single Responsibility Principle (SRP):**
  Setiap fitur punya file locator sendiri (`LoginLocators`, `CartLocators`, dll.), jadi lebih mudah maintenance, review, dan scaling.
* **Minim Konflik Merge:**
  Jika ada perubahan XPath, hanya edit file Keywords modul terkait.
  Kolaborasi tim lebih aman dan risiko konflik sangat kecil.
* **Perubahan Test Case Lebih Mudah:**
  Update XPath tidak perlu edit test case, cukup update 1 file locator saja.

---

## Cara Update XPath

Jika ada perubahan struktur halaman, **cukup edit file di folder `Keywords/` modul terkait** (misal: login, cart, checkout).
Test case tidak perlu disentuh sama sekali, selama nama fungsi locators tidak berubah.

---

## Cara Menjalankan Test

### **1. Jalankan via GUI**

* Buka project di Katalon Studio.
* Atur credentials di `Profiles/default.glbl` (`baseUrl`, `stdUser`, `stdPass`).
* Pilih test case atau suite, klik **Run**.

### **2. Jalankan via CLI (Headless/Console)**

```bash
katalonc -noSplash -runMode=console -projectPath="." -retry=0 -testSuitePath="Test Suites/SmokeSuite" -executionProfile="default" -browserType="Chrome"
```

---

## Contoh Penggunaan Modular Locator

### Login

```groovy
import login.LoginLocators as L

WebUI.setText(L.makeLoginTO(L.txtUsername()), GlobalVariable.stdUser)
WebUI.setText(L.makeLoginTO(L.txtPassword()), GlobalVariable.stdPass)
WebUI.click(L.makeLoginTO(L.btnLogin()))
WebUI.verifyElementNotPresent(L.makeLoginTO(L.lblError()), 3)
```

### Cart

```groovy
import cart.CartLocators as C

WebUI.click(C.makeCartTO(C.btnAddToCart('Sauce Labs Backpack')))
WebUI.click(C.makeCartTO(C.lnkCart()))
WebUI.click(C.makeCartTO(C.btnRemoveFromCart('Sauce Labs Backpack')))
WebUI.verifyElementNotPresent(C.makeCartTO(C.icnCartBadge()), 3)
```

### Checkout

```groovy
import checkout.CheckoutLocators as CO

WebUI.setText(CO.makeCheckoutTO(CO.txtFirstName()), 'Andi')
WebUI.setText(CO.makeCheckoutTO(CO.txtLastName()), 'QA')
WebUI.setText(CO.makeCheckoutTO(CO.txtZip()), '12345')
WebUI.click(CO.makeCheckoutTO(CO.btnContinue()))
WebUI.click(CO.makeCheckoutTO(CO.btnFinish()))
WebUI.verifyElementPresent(CO.makeCheckoutTO(CO.lblSuccess()), 3)
```

---

## Test Case Utama

* **Login:** positive & negative (kombinasi salah username/password/kosong)
* **Cart:** tambah & hapus produk, negative produk tidak ada/cart kosong
* **Checkout:** positive (isi lengkap), negative (field kosong: first name, last name, zip)

---

## Listener LoggingListener.groovy

Listener otomatis log setiap test PASS/FAIL secara detail, sehingga audit easier.

---

## Catatan

* Semua test case **tidak perlu Object Repository**, cukup panggil fungsi modular.
