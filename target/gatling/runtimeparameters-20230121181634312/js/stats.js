var stats = {
    type: "GROUP",
name: "All Requests",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "All Requests",
    "numberOfRequests": {
        "total": "203",
        "ok": "203",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "152",
        "ok": "152",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2751",
        "ok": "2751",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "255",
        "ok": "255",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "240",
        "ok": "240",
        "ko": "-"
    },
    "percentiles1": {
        "total": "180",
        "ok": "180",
        "ko": "-"
    },
    "percentiles2": {
        "total": "231",
        "ok": "231",
        "ko": "-"
    },
    "percentiles3": {
        "total": "680",
        "ok": "680",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1048",
        "ok": "1048",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 196,
    "percentage": 97
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 6,
    "percentage": 3
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "htmlName": "t ≥ 1200 ms",
    "count": 1,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "3.691",
        "ok": "3.691",
        "ko": "-"
    }
},
contents: {
"req_get-all-video-g-3129c": {
        type: "REQUEST",
        name: "Get all video game",
path: "Get all video game",
pathFormatted: "req_get-all-video-g-3129c",
stats: {
    "name": "Get all video game",
    "numberOfRequests": {
        "total": "203",
        "ok": "203",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "152",
        "ok": "152",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2751",
        "ok": "2751",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "255",
        "ok": "255",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "240",
        "ok": "240",
        "ko": "-"
    },
    "percentiles1": {
        "total": "180",
        "ok": "180",
        "ko": "-"
    },
    "percentiles2": {
        "total": "231",
        "ok": "231",
        "ko": "-"
    },
    "percentiles3": {
        "total": "680",
        "ok": "680",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1048",
        "ok": "1048",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "htmlName": "t < 800 ms",
    "count": 196,
    "percentage": 97
},
    "group2": {
    "name": "800 ms <= t < 1200 ms",
    "htmlName": "t ≥ 800 ms <br> t < 1200 ms",
    "count": 6,
    "percentage": 3
},
    "group3": {
    "name": "t ≥ 1200 ms",
    "htmlName": "t ≥ 1200 ms",
    "count": 1,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "htmlName": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "3.691",
        "ok": "3.691",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
