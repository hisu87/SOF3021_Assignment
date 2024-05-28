USE [SOF3021_J5_CoffeeShop]
GO
SET IDENTITY_INSERT [dbo].[categories] ON 
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (1, N'Cà Phê Việt Nam')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (2, N'Cà Phê Máy')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (3, N'Cold Brew')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (4, N'Trà Trái Cây')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (5, N'Trà Sữa Macchiato')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (6, N'CloudFee')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (7, N'CloudTea Mochi')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (8, N'Hi-Tea Trà')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (9, N'Hi-Tea Đá Tuyết')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (10, N'Trà Xanh Tây Bắc')
GO
INSERT [dbo].[categories] ([id], [name]) VALUES (11, N'Chocolate')
GO
SET IDENTITY_INSERT [dbo].[categories] OFF
GO
SET IDENTITY_INSERT [dbo].[drinks] ON 
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (2, 1, N'Thức uống giúp tỉnh táo tức thì để bắt đầu ngày mới thật hứng khởi. Không đắng khét như cà phê truyền thống, The Coffee House Sữa Đá mang hương vị hài hoà đầy lôi cuốn. Là sự đậm đà của 100% cà phê Arabica Cầu Đất rang vừa tới, biến tấu tinh tế với sữa đặc và kem sữa ngọt ngào cực quyến rũ. Càng hấp dẫn hơn với topping thạch 100% cà phê nguyên chất giúp giữ trọn vị ngon đến ngụm cuối cùng.', N'2.webp', N'The Coffee House Sữa Đá', 39000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (3, 1, N'Cà phê Đắk Lắk nguyên chất được pha phin truyền thống kết hợp với sữa đặc tạo nên hương vị đậm đà, hài hòa giữa vị ngọt đầu lưỡi và vị đắng thanh thoát nơi hậu vị.', N'3.webp', N'Cà Phê Sữa Đá', 29000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (4, 1, N'Cà phê được pha phin truyền thống kết hợp với sữa đặc tạo nên hương vị đậm đà, hài hòa giữa vị ngọt đầu lưỡi và vị đắng thanh thoát nơi hậu vị.', N'4.webp', N'Cà Phê Sữa Nóng', 39000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (5, 1, N'Bạc sỉu chính là "Ly sữa trắng kèm một chút cà phê". Thức uống này rất phù hợp những ai vừa muốn trải nghiệm chút vị đắng của cà phê vừa muốn thưởng thức vị ngọt béo ngậy từ sữa.', N'5.jpg', N'Bạc Sỉu', 29000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (6, 1, N'Bạc sỉu chính là "Ly sữa trắng kèm một chút cà phê". Thức uống này rất phù hợp những ai vừa muốn trải nghiệm chút vị đắng của cà phê vừa muốn thưởng thức vị ngọt béo ngậy từ sữa.', N'6.webp', N'Bạc Sỉu Nóng', 39000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (7, 1, N'Nếu chuộng vị cà phê đậm đà, bùng nổ và thích vị đường đen ngọt thơm, Đường Đen Sữa Đá đích thị là thức uống dành cho bạn. Không chỉ giúp bạn tỉnh táo buổi sáng, Đường Đen Sữa Đá còn hấp dẫn đến ngụm cuối cùng bởi thạch cà phê giòn dai, nhai cực cuốn. - Khuấy đều trước khi sử dụng', N'1.webp', N'Đường Đen Sữa Đá', 45000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (8, 1, N'Không ngọt ngào như Bạc sỉu hay Cà phê sữa, Cà phê đen mang trong mình phong vị trầm lắng, thi vị hơn. Người ta thường phải ngồi rất lâu mới cảm nhận được hết hương thơm ngào ngạt, phảng phất mùi cacao và cái đắng mượt mà trôi tuột xuống vòm họng.', N'7.jpg', N'Cà Phê Đen Đá', 29000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (9, 1, N'Không ngọt ngào như Bạc sỉu hay Cà phê sữa, Cà phê đen mang trong mình phong vị trầm lắng, thi vị hơn. Người ta thường phải ngồi rất lâu mới cảm nhận được hết hương thơm ngào ngạt, phảng phất mùi cacao và cái đắng mượt mà trôi tuột xuống vòm họng.', N'8.webp', N'Cà Phê Đen Nóng', 39000, 1)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (10, 1, N'Đường Đen Marble Latte êm dịu cực hấp dẫn bởi vị cà phê đắng nhẹ hoà quyện cùng vị đường đen ngọt thơm và sữa tươi béo mịn. Sự kết hợp đầy mới mẻ của cà phê và đường đen cũng tạo nên diện mạo phân tầng đẹp mắt. Đây là lựa chọn đáng thử để bạn khởi đầu ngày mới đầy hứng khởi. - Khuấy đều trước khi sử dụng', N'9.jpg', N'Đường Đen Marble Latte', 55000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (11, 1, N'Khuấy đều trước khi sử dụng Caramel Macchiato sẽ mang đến một sự ngạc nhiên thú vị khi vị thơm béo của bọt sữa, sữa tươi, vị đắng thanh thoát của cà phê Espresso hảo hạng và vị ngọt đậm của sốt caramel được gói gọn trong một tách cà phê.', N'10.webp', N'Caramel Macchiato Đá', 55000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (12, 1, N'Caramel Macchiato sẽ mang đến một sự ngạc nhiên thú vị khi vị thơm béo của bọt sữa, sữa tươi, vị đắng thanh thoát của cà phê Espresso hảo hạng và vị ngọt đậm của sốt caramel được gói gọn trong một tách cà phê.', N'11.jpg', N'Caramel Macchiato Nóng', 55000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (13, 1, N'Một sự kết hợp tinh tế giữa vị đắng cà phê Espresso nguyên chất hòa quyện cùng vị sữa nóng ngọt ngào, bên trên là một lớp kem mỏng nhẹ tạo nên một tách cà phê hoàn hảo về hương vị lẫn nhãn quan.', N'12.webp', N'Latte Đá', 55000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (14, 1, N'Một sự kết hợp tinh tế giữa vị đắng cà phê Espresso nguyên chất hòa quyện cùng vị sữa nóng ngọt ngào, bên trên là một lớp kem mỏng nhẹ tạo nên một tách cà phê hoàn hảo về hương vị lẫn nhãn quan.', N'13.webp', N'Latte Nóng', 55000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (15, 1, N'Americano được pha chế bằng cách pha thêm nước với tỷ lệ nhất định vào tách cà phê Espresso, từ đó mang lại hương vị nhẹ nhàng và giữ trọn được mùi hương cà phê đặc trưng.', N'14.jpg', N'Americano Đá', 45000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (16, 1, N'Americano được pha chế bằng cách pha thêm nước với tỷ lệ nhất định vào tách cà phê Espresso, từ đó mang lại hương vị nhẹ nhàng và giữ trọn được mùi hương cà phê đặc trưng.', N'15.jpg', N'Americano Nóng', 45000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (17, 1, N'Capuchino là thức uống hòa quyện giữa hương thơm của sữa, vị béo của bọt kem cùng vị đậm đà từ cà phê Espresso. Tất cả tạo nên một hương vị đặc biệt, một chút nhẹ nhàng, trầm lắng và tinh tế.', N'16.webp', N'Cappuccino Đá', 55000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (18, 1, N'Capuchino là thức uống hòa quyện giữa hương thơm của sữa, vị béo của bọt kem cùng vị đậm đà từ cà phê Espresso. Tất cả tạo nên một hương vị đặc biệt, một chút nhẹ nhàng, trầm lắng và tinh tế.', N'17.webp', N'Cappuccino Nóng', 55000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (19, 1, N'Một tách Espresso nguyên bản được bắt đầu bởi những hạt Arabica chất lượng, phối trộn với tỉ lệ cân đối hạt Robusta, cho ra vị ngọt caramel, vị chua dịu và sánh đặc.', N'18.webp', N'Espresso Đá', 49000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (20, 1, N'Một tách Espresso nguyên bản được bắt đầu bởi những hạt Arabica chất lượng, phối trộn với tỉ lệ cân đối hạt Robusta, cho ra vị ngọt caramel, vị chua dịu và sánh đặc.', N'19.webp', N'Espresso Nóng', 45000, 2)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (21, 1, N'Vị chua ngọt của trái phúc bồn tử, làm dậy lên hương vị trái cây tự nhiên vốn sẵn có trong hạt cà phê, hòa quyện thêm vị đăng đắng, ngọt dịu nhẹ nhàng của Cold Brew 100% hạt Arabica Cầu Đất để mang đến một cách thưởng thức cà phê hoàn toàn mới, vừa thơm lừng hương cà phê quen thuộc, vừa nhẹ nhàng và thanh mát bởi hương trái cây đầy thú vị.', N'20.webp', N'Cold Brew Phúc Bồn Tử', 49000, 3)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (22, 1, N'Thanh mát và cân bằng với hương vị cà phê nguyên bản 100% Arabica Cầu Đất cùng sữa tươi thơm béo cho từng ngụm tròn vị, hấp dẫn.', N'21.webp', N'Cold Brew Sữa Tươi', 49000, 3)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (23, 1, N'Tại The Coffee House, Cold Brew được ủ và phục vụ mỗi ngày từ 100% hạt Arabica Cầu Đất với hương gỗ thông, hạt dẻ, nốt sô-cô-la đặc trưng, thoang thoảng hương khói nhẹ giúp Cold Brew giữ nguyên vị tươi mới.', N'22.webp', N'Cold Brew Truyền Thống', 45000, 3)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (24, 1, N'Thức uống mang hương vị của nhãn, của sen, của trà Oolong đầy thanh mát cho tất cả các thành viên trong dịp Tết này. An lành, thư thái và đậm đà chính là những gì The Coffee House mong muốn gửi trao đến bạn và gia đình.', N'23.webp', N'Trà Long Nhãn Hạt Sen', 49000, 4)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (25, 1, N'Vị thanh ngọt của đào, vị chua dịu của Cam Vàng nguyên vỏ, vị chát của trà đen tươi được ủ mới mỗi 4 tiếng, cùng hương thơm nồng đặc trưng của sả chính là điểm sáng làm nên sức hấp dẫn của thức uống này.', N'24.webp', N'Trà Đào Cam Sả Đá', 49000, 4)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (26, 1, N'Vị thanh ngọt của đào, vị chua dịu của Cam Vàng nguyên vỏ, vị chát của trà đen tươi được ủ mới mỗi 4 tiếng, cùng hương thơm nồng đặc trưng của sả chính là điểm sáng làm nên sức hấp dẫn của thức uống này.', N'25.webp', N'Trà Đào Cam Sả Nóng', 59000, 4)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (27, 1, N'Nền trà oolong hảo hạng kết hợp cùng hạt sen tươi, bùi bùi và lớp foam cheese béo ngậy. Trà hạt sen là thức uống thanh mát, nhẹ nhàng phù hợp cho cả buổi sáng và chiều tối.', N'26.webp', N'Trà Hạt Sen Đá', 49000, 4)
GO
INSERT [dbo].[drinks] ([id], [active], [description], [drink_image], [name], [price], [category_id]) VALUES (28, 1, N'Nền trà oolong hảo hạng kết hợp cùng hạt sen tươi, bùi bùi thơm ngon. Trà hạt sen là thức uống thanh mát, nhẹ nhàng phù hợp cho cả buổi sáng và chiều tối.', N'27.webp', N'Trà Hạt Sen Nóng', 59000, 4)
GO
SET IDENTITY_INSERT [dbo].[drinks] OFF
GO
SET IDENTITY_INSERT [dbo].[order_statuses] ON 
GO
INSERT [dbo].[order_statuses] ([id], [name]) VALUES (1, N'Pending')
GO
INSERT [dbo].[order_statuses] ([id], [name]) VALUES (2, N'In Progress')
GO
INSERT [dbo].[order_statuses] ([id], [name]) VALUES (3, N'Shipping')
GO
INSERT [dbo].[order_statuses] ([id], [name]) VALUES (4, N'Delivered')
GO
INSERT [dbo].[order_statuses] ([id], [name]) VALUES (5, N'Completed')
GO
INSERT [dbo].[order_statuses] ([id], [name]) VALUES (6, N'Cancelled')
GO
SET IDENTITY_INSERT [dbo].[order_statuses] OFF
GO
SET IDENTITY_INSERT [dbo].[payment_methods] ON 
GO
INSERT [dbo].[payment_methods] ([id], [name]) VALUES (1, N'Cash On Delivery (COD)')
GO
INSERT [dbo].[payment_methods] ([id], [name]) VALUES (2, N'ATM Card')
GO
INSERT [dbo].[payment_methods] ([id], [name]) VALUES (3, N'Visa Card')
GO
INSERT [dbo].[payment_methods] ([id], [name]) VALUES (4, N'Master Card')
GO
INSERT [dbo].[payment_methods] ([id], [name]) VALUES (5, N'MoMo')
GO
INSERT [dbo].[payment_methods] ([id], [name]) VALUES (6, N'ZaloPay')
GO
INSERT [dbo].[payment_methods] ([id], [name]) VALUES (7, N'VNPAY')
GO
INSERT [dbo].[payment_methods] ([id], [name]) VALUES (8, N'Viettel Money')
GO
INSERT [dbo].[payment_methods] ([id], [name]) VALUES (9, N'Apple Pay')
GO
SET IDENTITY_INSERT [dbo].[payment_methods] OFF
GO
INSERT [dbo].[users] ([username], [active], [admin], [email], [first_name], [last_name], [password], [phone_number]) VALUES (N'admin', 1, 1, N'admin@gmail.com', N'admin', N'nguyen', N'123456', N'0123456789')
GO

