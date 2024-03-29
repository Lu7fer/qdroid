package cf.vbnm.amoeba.qdroid.cq.api

import cf.vbnm.amoeba.qdroid.cq.api.enums.Retcode
import cf.vbnm.amoeba.qdroid.cq.api.enums.Status
import com.fasterxml.jackson.annotation.JsonProperty

abstract class BaseApi<T>(
    @JsonProperty("status") val status: Status,
    @JsonProperty("retcode") val retcode: Retcode,
    @JsonProperty("msg") val msg: String? = null,
    @JsonProperty("wording") val wording: String? = null,
    @JsonProperty("echo") val echo: String? = null,
    @JsonProperty("data") val data: T
) {

    override fun toString(): String {
        return "Api(status=$status, retcode=$retcode, msg=$msg, wording=$wording, echo=$echo, data=$data"
    }
}