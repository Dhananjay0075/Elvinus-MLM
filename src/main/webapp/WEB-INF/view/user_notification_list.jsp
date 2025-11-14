
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:if test="${!empty notifyList}">

	<ul class="message-list">

		<%int i = 1; %>
		<c:forEach items="${notifyList}" var="val">

			<c:if test="${val.notification_status == 'Unread'}">

				<li class="unread"><a href="#"
					onclick="showNotifyMsg('${val.notification_id}')">
						<div class="col-mail col-mail-1">
							<div class="checkbox-wrapper-mail">
								<input type="checkbox" id="chk1"> <label for="chk1"
									class="toggle"></label>
							</div>
							<p class="title">${val.notify_via}</p>
							<span class="mdi mdi-delete font-18 align-middle mr-2"
								onclick="deleteMsg('${val.notification_id}')"></span>
						</div>

						<div class="col-mail col-mail-2">
							<div class="subject">${val.notification_msg}</div>
							<div class="date" style="padding-left: 2px;">
								<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss"
									value="${val.notify_date}" />
							</div>
						</div>
				</a></li>

			</c:if>

			<c:if test="${val.notification_status == 'read'}">

				<li><a href="#"
					onclick="showNotifyMsg('${val.notification_id}')">
						<div class="col-mail col-mail-1">
							<div class="checkbox-wrapper-mail">
								<input type="checkbox" id="chk1"> <label for="chk1"
									class="toggle"></label>
							</div>
							<p class="title">${val.notify_via}</p>
							<span class="mdi mdi-delete font-18 align-middle mr-2"
								onclick="deleteMsg('${val.notification_id}')"></span>
						</div>

						<div class="col-mail col-mail-2">
							<div class="subject">${val.notification_msg}</div>
							<div class="date">
								<fmt:formatDate pattern="dd/MM/yyyy HH:mm:ss"
									value="${val.notify_date}" />
							</div>
						</div>
				</a></li>

			</c:if>

		</c:forEach>


	</ul>

</c:if>

<c:if test="${empty notifyList}">

	<div
		class="alert alert-danger alert-dismissible bg-danger text-white border-0 fade show"
		role="alert">No Message for you !</div>

</c:if>
