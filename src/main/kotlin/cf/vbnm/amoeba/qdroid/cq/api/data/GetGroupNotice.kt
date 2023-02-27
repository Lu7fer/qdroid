package cf.vbnm.amoeba.qdroid.cq.api.data

import cf.vbnm.amoeba.qdroid.cq.api.BaseApi
import cf.vbnm.amoeba.qdroid.cq.api.enums.Status
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper

class GetGroupNotice(
    @JsonProperty("status")
    status: Status,
    @JsonProperty("retcode")
    retcode: Int,
    @JsonProperty("msg")
    msg: String? = null,
    @JsonProperty("wording")
    wording: String? = null,
    @JsonProperty("echo")
    echo: String? = null,
    @JsonProperty("data")
    data: GroupNotice
) : BaseApi<GetGroupNotice.GroupNotice>(status, retcode, msg, wording, echo, data) {

    companion object {
        fun parseApiRet(map: Map<String, Any?>, objectMapper: ObjectMapper): BaseApi<*> {
            return objectMapper.convertValue(map, GetGroupNotice::class.java)
        }
    }

    data class GroupNotice(
        @JsonProperty("sender_id")
        val senderId: Long,
        @JsonProperty("publish_time")
        val publishTime: Long,
        @JsonProperty("message")
        val message: Message,
    ) {
        data class Message(
            @JsonProperty("text")
            val text: String,
            @JsonProperty("images")
            val images: MutableList<Images>,
        ) {
            data class Images(
                @JsonProperty("height")
                val height: String,
                @JsonProperty("width")
                val width: String,
                @JsonProperty("id")
                val id: String,
            )
        }
    }
}