package com.codylab.domain

val JPY_CURRENCY = Currency("JPY", "Japanese Yen")
val DEFAULT_CURRENCY = JPY_CURRENCY
val SUPPORTED_CURRENCIES = hashMapOf(
    "AED" to Currency("AED", "United Arab Emirates Dirham"),
    "AFN" to Currency("AFN", "Afghan Afghani"),
    "ALL" to Currency("ALL", "Albanian Lek"),
    "AMD" to Currency("AMD", "Armenian Dram"),
    "ANG" to Currency("ANG", "Netherlands Antillean Guilder"),
    "AOA" to Currency("AOA", "Angolan Kwanza"),
    "ARS" to Currency("ARS", "Argentine Peso"),
    "AUD" to Currency("AUD", "Australian Dollar"),
    "AWG" to Currency("AWG", "Aruban Florin"),
    "AZN" to Currency("AZN", "Azerbaijani Manat"),
    "BAM" to Currency("BAM", "Bosnia-Herzegovina Convertible Mark"),
    "BBD" to Currency("BBD", "Barbadian Dollar"),
    "BDT" to Currency("BDT", "Bangladeshi Taka"),
    "BGN" to Currency("BGN", "Bulgarian Lev"),
    "BHD" to Currency("BHD", "Bahraini Dinar"),
    "BIF" to Currency("BIF", "Burundian Franc"),
    "BMD" to Currency("BMD", "Bermudan Dollar"),
    "BND" to Currency("BND", "Brunei Dollar"),
    "BOB" to Currency("BOB", "Bolivian Boliviano"),
    "BRL" to Currency("BRL", "Brazilian Real"),
    "BSD" to Currency("BSD", "Bahamian Dollar"),
    "BTC" to Currency("BTC", "Bitcoin"),
    "BTN" to Currency("BTN", "Bhutanese Ngultrum"),
    "BWP" to Currency("BWP", "Botswanan Pula"),
    "BYR" to Currency("BYR", "Belarusian Ruble"),
    "BZD" to Currency("BZD", "Belize Dollar"),
    "CAD" to Currency("CAD", "Canadian Dollar"),
    "CDF" to Currency("CDF", "Congolese Franc"),
    "CHF" to Currency("CHF", "Swiss Franc"),
    "CLF" to Currency("CLF", "Chilean Unit of Account (UF)"),
    "CLP" to Currency("CLP", "Chilean Peso"),
    "CNY" to Currency("CNY", "Chinese Yuan"),
    "COP" to Currency("COP", "Colombian Peso"),
    "CRC" to Currency("CRC", "Costa Rican Colón"),
    "CUC" to Currency("CUC", "Cuban Convertible Peso"),
    "CUP" to Currency("CUP", "Cuban Peso"),
    "CVE" to Currency("CVE", "Cape Verdean Escudo"),
    "CZK" to Currency("CZK", "Czech Republic Koruna"),
    "DJF" to Currency("DJF", "Djiboutian Franc"),
    "DKK" to Currency("DKK", "Danish Krone"),
    "DOP" to Currency("DOP", "Dominican Peso"),
    "DZD" to Currency("DZD", "Algerian Dinar"),
    "EGP" to Currency("EGP", "Egyptian Pound"),
    "ERN" to Currency("ERN", "Eritrean Nakfa"),
    "ETB" to Currency("ETB", "Ethiopian Birr"),
    "EUR" to Currency("EUR", "Euro"),
    "FJD" to Currency("FJD", "Fijian Dollar"),
    "FKP" to Currency("FKP", "Falkland Islands Pound"),
    "GBP" to Currency("GBP", "British Pound Sterling"),
    "GEL" to Currency("GEL", "Georgian Lari"),
    "GGP" to Currency("GGP", "Guernsey Pound"),
    "GHS" to Currency("GHS", "Ghanaian Cedi"),
    "GIP" to Currency("GIP", "Gibraltar Pound"),
    "GMD" to Currency("GMD", "Gambian Dalasi"),
    "GNF" to Currency("GNF", "Guinean Franc"),
    "GTQ" to Currency("GTQ", "Guatemalan Quetzal"),
    "GYD" to Currency("GYD", "Guyanaese Dollar"),
    "HKD" to Currency("HKD", "Hong Kong Dollar"),
    "HNL" to Currency("HNL", "Honduran Lempira"),
    "HRK" to Currency("HRK", "Croatian Kuna"),
    "HTG" to Currency("HTG", "Haitian Gourde"),
    "HUF" to Currency("HUF", "Hungarian Forint"),
    "IDR" to Currency("IDR", "Indonesian Rupiah"),
    "ILS" to Currency("ILS", "Israeli New Sheqel"),
    "IMP" to Currency("IMP", "Manx pound"),
    "INR" to Currency("INR", "Indian Rupee"),
    "IQD" to Currency("IQD", "Iraqi Dinar"),
    "IRR" to Currency("IRR", "Iranian Rial"),
    "ISK" to Currency("ISK", "Icelandic Króna"),
    "JEP" to Currency("JEP", "Jersey Pound"),
    "JMD" to Currency("JMD", "Jamaican Dollar"),
    "JOD" to Currency("JOD", "Jordanian Dinar"),
    "JPY" to JPY_CURRENCY,
    "KES" to Currency("KES", "Kenyan Shilling"),
    "KGS" to Currency("KGS", "Kyrgystani Som"),
    "KHR" to Currency("KHR", "Cambodian Riel"),
    "KMF" to Currency("KMF", "Comorian Franc"),
    "KPW" to Currency("KPW", "North Korean Won"),
    "KRW" to Currency("KRW", "South Korean Won"),
    "KWD" to Currency("KWD", "Kuwaiti Dinar"),
    "KYD" to Currency("KYD", "Cayman Islands Dollar"),
    "KZT" to Currency("KZT", "Kazakhstani Tenge"),
    "LAK" to Currency("LAK", "Laotian Kip"),
    "LBP" to Currency("LBP", "Lebanese Pound"),
    "LKR" to Currency("LKR", "Sri Lankan Rupee"),
    "LRD" to Currency("LRD", "Liberian Dollar"),
    "LSL" to Currency("LSL", "Lesotho Loti"),
    "LTL" to Currency("LTL", "Lithuanian Litas"),
    "LVL" to Currency("LVL", "Latvian Lats"),
    "LYD" to Currency("LYD", "Libyan Dinar"),
    "MAD" to Currency("MAD", "Moroccan Dirham"),
    "MDL" to Currency("MDL", "Moldovan Leu"),
    "MGA" to Currency("MGA", "Malagasy Ariary"),
    "MKD" to Currency("MKD", "Macedonian Denar"),
    "MMK" to Currency("MMK", "Myanma Kyat"),
    "MNT" to Currency("MNT", "Mongolian Tugrik"),
    "MOP" to Currency("MOP", "Macanese Pataca"),
    "MRO" to Currency("MRO", "Mauritanian Ouguiya"),
    "MUR" to Currency("MUR", "Mauritian Rupee"),
    "MVR" to Currency("MVR", "Maldivian Rufiyaa"),
    "MWK" to Currency("MWK", "Malawian Kwacha"),
    "MXN" to Currency("MXN", "Mexican Peso"),
    "MYR" to Currency("MYR", "Malaysian Ringgit"),
    "MZN" to Currency("MZN", "Mozambican Metical"),
    "NAD" to Currency("NAD", "Namibian Dollar"),
    "NGN" to Currency("NGN", "Nigerian Naira"),
    "NIO" to Currency("NIO", "Nicaraguan Córdoba"),
    "NOK" to Currency("NOK", "Norwegian Krone"),
    "NPR" to Currency("NPR", "Nepalese Rupee"),
    "NZD" to Currency("NZD", "New Zealand Dollar"),
    "OMR" to Currency("OMR", "Omani Rial"),
    "PAB" to Currency("PAB", "Panamanian Balboa"),
    "PEN" to Currency("PEN", "Peruvian Nuevo Sol"),
    "PGK" to Currency("PGK", "Papua New Guinean Kina"),
    "PHP" to Currency("PHP", "Philippine Peso"),
    "PKR" to Currency("PKR", "Pakistani Rupee"),
    "PLN" to Currency("PLN", "Polish Zloty"),
    "PYG" to Currency("PYG", "Paraguayan Guarani"),
    "QAR" to Currency("QAR", "Qatari Rial"),
    "RON" to Currency("RON", "Romanian Leu"),
    "RSD" to Currency("RSD", "Serbian Dinar"),
    "RUB" to Currency("RUB", "Russian Ruble"),
    "RWF" to Currency("RWF", "Rwandan Franc"),
    "SAR" to Currency("SAR", "Saudi Riyal"),
    "SBD" to Currency("SBD", "Solomon Islands Dollar"),
    "SCR" to Currency("SCR", "Seychellois Rupee"),
    "SDG" to Currency("SDG", "Sudanese Pound"),
    "SEK" to Currency("SEK", "Swedish Krona"),
    "SGD" to Currency("SGD", "Singapore Dollar"),
    "SHP" to Currency("SHP", "Saint Helena Pound"),
    "SLL" to Currency("SLL", "Sierra Leonean Leone"),
    "SOS" to Currency("SOS", "Somali Shilling"),
    "SRD" to Currency("SRD", "Surinamese Dollar"),
    "STD" to Currency("STD", "São Tomé and Príncipe Dobra"),
    "SVC" to Currency("SVC", "Salvadoran Colón"),
    "SYP" to Currency("SYP", "Syrian Pound"),
    "SZL" to Currency("SZL", "Swazi Lilangeni"),
    "THB" to Currency("THB", "Thai Baht"),
    "TJS" to Currency("TJS", "Tajikistani Somoni"),
    "TMT" to Currency("TMT", "Turkmenistani Manat"),
    "TND" to Currency("TND", "Tunisian Dinar"),
    "TOP" to Currency("TOP", "Tongan Paʻanga"),
    "TRY" to Currency("TRY", "Turkish Lira"),
    "TTD" to Currency("TTD", "Trinidad and Tobago Dollar"),
    "TWD" to Currency("TWD", "New Taiwan Dollar"),
    "TZS" to Currency("TZS", "Tanzanian Shilling"),
    "UAH" to Currency("UAH", "Ukrainian Hryvnia"),
    "UGX" to Currency("UGX", "Ugandan Shilling"),
    "USD" to Currency("USD", "United States Dollar"),
    "UYU" to Currency("UYU", "Uruguayan Peso"),
    "UZS" to Currency("UZS", "Uzbekistan Som"),
    "VEF" to Currency("VEF", "Venezuelan Bolívar Fuerte"),
    "VND" to Currency("VND", "Vietnamese Dong"),
    "VUV" to Currency("VUV", "Vanuatu Vatu"),
    "WST" to Currency("WST", "Samoan Tala"),
    "XAF" to Currency("XAF", "CFA Franc BEAC"),
    "XAG" to Currency("XAG", "Silver (troy ounce)"),
    "XAU" to Currency("XAU", "Gold (troy ounce)"),
    "XCD" to Currency("XCD", "East Caribbean Dollar"),
    "XDR" to Currency("XDR", "Special Drawing Rights"),
    "XOF" to Currency("XOF", "CFA Franc BCEAO"),
    "XPF" to Currency("XPF", "CFP Franc"),
    "YER" to Currency("YER", "Yemeni Rial"),
    "ZAR" to Currency("ZAR", "South African Rand"),
    "ZMK" to Currency("ZMK", "Zambian Kwacha (pre-2013)"),
    "ZMW" to Currency("ZMW", "Zambian Kwacha"),
    "ZWL" to Currency("ZWL", "Zimbabwean Dollar")
)