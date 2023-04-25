package cf.vbnm.amoeba.qdroid.cq.code.data

import cf.vbnm.amoeba.qdroid.cq.code.BaseMsgPartial
import cf.vbnm.amoeba.qdroid.cq.code.enums.MsgPartialType
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

class Json(
    @JsonProperty("data")
    data: JsonData
) : BaseMsgPartial<Json.JsonData>(MsgPartialType.JSON, data) {
    constructor(
        data: String,
        resid: Int?
    ) : this(JsonData(data, resid))

    @JsonInclude(JsonInclude.Include.NON_NULL)
    data class JsonData(
        @JsonProperty("data") val data: String,
        @JsonProperty("resid") val resid: Int?
    )
}