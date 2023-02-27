<div class="registration_form">

	<div class="title">
		<c:out value="${title}" />
	</div>


	<form name="form" action="controller" method="post"
		onsubmit="return validateRegistration()">
		<div class="form_wrap">
			<div class="input_grp">

				<td class="space_around_title_text">Login</td>
				<div class="input_wrap">
					<label for="login"><c:out value="${login}" /></label> <input
						type="text" id="login" name="login" value="enhort">
				</div>
				<td class="space_around_title_text">Password</td>
				<div class="input_wrap">
					<label for="password"><c:out value="${password}" /></label> <input
						type="text" id="password" name="password" value="123">
				</div>
				<td class="space_around_title_text">Repeate password</td>
				<div class="input_wrap">
					<label for="repeatPassword"><c:out
							value="${repeat_password}" /></label> <input type="text"
						id="repeatPassword" name="repeatPassword" value="123">
				</div>
				<td class="space_around_title_text">Email</td>
				<div class="input_wrap">
					<label for="email"><c:out value="${email}" /></label> <input
						type="text" id="email" name="email" value="enhort@mail.ru">
				</div>
				<td class="space_around_title_text">First name</td>
				<div class="input_wrap">
					<label for="name"><c:out value="${name}" /></label> <input
						type="text" id="name" name="name" value="Artem">
				</div>

				<td class="space_around_title_text">Surname</td>
				<div class="input_wrap">
					<label for="surname"><c:out value="${surname}" /></label> <input
						type="text" id="surname" name="surname" value="Ponikarov">
				</div>

				<div class="input_wrap">
					<td class="space_around_title_text">Adress</td> <label
						for="adress"><c:out value="${adress}" /></label> <input
						type="text" id="adress" name="adress" value="Kazan">
				</div>
				<div class="input_wrap">
					<td class="space_around_title_text">Tel number</td> <label
						for="tel"><c:out value="${tel}" /></label> <input
						type="text" id="tel" name="tel" value="79172000000">
				</div>
								<div class="input_wrap">
					<td class="space_around_title_text">Birthday date</td> <label
						for="birthday"><c:out value="${birthday}" /></label> <input
						type="date" id="birthday" name="birthday" value="1988-02-02">
				</div>
				<form>
					<input type="radio" id="gender-male" name="gender" value="male">
					<label for="gender-male">Male</label><br> <input type="radio"
						id="gender-female" name="gender" value="female"> <label
						for="gender-female">Female</label><br>

				</form>
			</div>
			<div class="input_wrap">
				<input type="hidden" name="command" value="do_registration" /> <input
					type="submit" value="Submit!" class="submit_btn">
			</div>

		</div>
	</form>
</div>
