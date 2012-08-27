/* SpryAccordion.js - Revision: Spry Preview Release 1.4 */

// Copyright (c) 2006. Adobe Systems Incorporated.
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions are met:
//
//   * Redistributions of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//   * Redistributions in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//   * Neither the name of Adobe Systems Incorporated nor the names of its
//     contributors may be used to endorse or promote products derived from this
//     software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
// AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
// IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
// ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
// LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
// CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
// INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
// ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
// POSSIBILITY OF SUCH DAMAGE.

function checkPasswordStrength(pwd)
{
	var strength_text = document.getElementById('strength_text');
	var strength_id = document.getElementById('strength_id');
	var progress_bar = document.getElementById('progress_bar');
 
	var strong = new RegExp('^(?=.{6,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$', 'g');
	var medium = new RegExp('^(?=.{5,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$', 'g');
	var enough = new RegExp('(?=.{4,}).*', 'g');
 
	if (strength_text == null)
	{
		return;
	}
 
	strength_id.value = 0;
 
	var width = pwd.length * 10;
 
	if (pwd.length == 0)
	{
		strength_text.innerHTML = '&nbsp;';
		progress_bar.style.backgroundColor = '#FFFFFF';
	}
	else if (false == enough.test(pwd))
	{
		strength_text.innerHTML = 'Too short';
		progress_bar.style.backgroundColor = '#DC143C';
	}
	else if (strong.test(pwd))
	{
		strength_text.innerHTML = 'Strong';
		width = 100;
		progress_bar.style.backgroundColor = '#228B22';
		strength_id.value = 3;
	}
	else if (medium.test(pwd))
	{
		strength_text.innerHTML = 'Medium';
		width = 70;
		progress_bar.style.backgroundColor = '#FF8C30';
		strength_id.value = 2;
	}
	else
	{
		width = 60;
		strength_text.innerHTML = 'Weak';
		progress_bar.style.backgroundColor = '#FFD700';
		strength_id.value = 1;
	}
 
	progress_bar.style.width = width + '%';
 
	document.getElementById('password_strength').style.display = (pwd.length == 0)?'none':'';
}