$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ebay.feature");
formatter.feature({
  "line": 2,
  "name": "ebay",
  "description": "",
  "id": "ebay",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@ebay"
    }
  ]
});
formatter.scenarioOutline({
  "line": 16,
  "name": "Search and Add multiple Items to Cart",
  "description": "",
  "id": "ebay;search-and-add-multiple-items-to-cart",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 15,
      "name": "@Regression,"
    },
    {
      "line": 15,
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "User search for an item \"\u003cMobile\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User selects the First Item listed",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User adds the item with \"\u003cColor\u003e\" color and \"\u003cRam\u003e\" Ram to cart",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Verify Item is succesfully added to cart",
  "keyword": "And "
});
formatter.examples({
  "line": 21,
  "name": "",
  "description": "",
  "id": "ebay;search-and-add-multiple-items-to-cart;",
  "rows": [
    {
      "cells": [
        "Mobile",
        "Color",
        "Ram"
      ],
      "line": 22,
      "id": "ebay;search-and-add-multiple-items-to-cart;;1"
    },
    {
      "cells": [
        "IPhone 6",
        "Silver",
        "16GB"
      ],
      "line": 23,
      "id": "ebay;search-and-add-multiple-items-to-cart;;2"
    },
    {
      "cells": [
        "Iphone 7",
        "Black",
        "128GB"
      ],
      "line": 24,
      "id": "ebay;search-and-add-multiple-items-to-cart;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User launch the website \"https://www.ebay.com/\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.ebay.com/",
      "offset": 25
    }
  ],
  "location": "BaseStepDef.launchApplication(String)"
});
formatter.result({
  "duration": 5242182578,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Search and Add multiple Items to Cart",
  "description": "",
  "id": "ebay;search-and-add-multiple-items-to-cart;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@ebay"
    },
    {
      "line": 15,
      "name": "@Regression,"
    },
    {
      "line": 15,
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "User search for an item \"IPhone 6\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User selects the First Item listed",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User adds the item with \"Silver\" color and \"16GB\" Ram to cart",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Verify Item is succesfully added to cart",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "IPhone 6",
      "offset": 25
    }
  ],
  "location": "BaseStepDef.iSetSearchRequest(String)"
});
formatter.result({
  "duration": 27096467054,
  "status": "passed"
});
formatter.match({
  "location": "BaseStepDef.selectFirstListedItem()"
});
formatter.result({
  "duration": 5869658672,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Silver",
      "offset": 25
    },
    {
      "val": "16GB",
      "offset": 44
    }
  ],
  "location": "BaseStepDef.addFirstListedItem(String,String)"
});
formatter.result({
  "duration": 6913677174,
  "status": "passed"
});
formatter.match({
  "location": "BaseStepDef.VerifyItemIsAdded()"
});
formatter.result({
  "duration": 90360384,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "User launch the website \"https://www.ebay.com/\"",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.ebay.com/",
      "offset": 25
    }
  ],
  "location": "BaseStepDef.launchApplication(String)"
});
formatter.result({
  "duration": 3050630399,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Search and Add multiple Items to Cart",
  "description": "",
  "id": "ebay;search-and-add-multiple-items-to-cart;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@ebay"
    },
    {
      "line": 15,
      "name": "@Regression,"
    },
    {
      "line": 15,
      "name": "@Smoke"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "User search for an item \"Iphone 7\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User selects the First Item listed",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "User adds the item with \"Black\" color and \"128GB\" Ram to cart",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Verify Item is succesfully added to cart",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Iphone 7",
      "offset": 25
    }
  ],
  "location": "BaseStepDef.iSetSearchRequest(String)"
});
formatter.result({
  "duration": 11953552252,
  "status": "passed"
});
formatter.match({
  "location": "BaseStepDef.selectFirstListedItem()"
});
formatter.result({
  "duration": 6181157465,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Black",
      "offset": 25
    },
    {
      "val": "128GB",
      "offset": 43
    }
  ],
  "location": "BaseStepDef.addFirstListedItem(String,String)"
});
formatter.result({
  "duration": 4167891608,
  "status": "passed"
});
formatter.match({
  "location": "BaseStepDef.VerifyItemIsAdded()"
});
formatter.result({
  "duration": 125816976,
  "status": "passed"
});
});