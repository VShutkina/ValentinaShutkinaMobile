Execute the following steps to run Mobile Appium tests:
1. Login to EPAM mobile cloud and copy token value
2. Add new "TOKEN" Environment Variables on Windows:
    - Right-click the Computer icon and choose Properties, or in Windows Control Panel, choose System.
    - Choose Advanced system settings.
    - On the Advanced tab, click Environment Variables.
    - Click New to create a new environment variable. Click Edit to modify an existing environment variable.
    - add token value for to access EPAM mobile cloud
    - restart Windows
3. Check that devices (ios = 00008020-001C10600E32002E, android = 89UX0H10H) are available. Change udid, if it's necessary
2. Run tests via maven profiles: NativeApp or WebApp or iOSWeb or iOSNative