namespace SQEditor.GUI.Items
{
    partial class ItemEditor
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.TreeNode treeNode1 = new System.Windows.Forms.TreeNode("Sword");
            System.Windows.Forms.TreeNode treeNode2 = new System.Windows.Forms.TreeNode("Axe");
            System.Windows.Forms.TreeNode treeNode3 = new System.Windows.Forms.TreeNode("Mace");
            System.Windows.Forms.TreeNode treeNode4 = new System.Windows.Forms.TreeNode("Dagger");
            System.Windows.Forms.TreeNode treeNode5 = new System.Windows.Forms.TreeNode("Flail");
            System.Windows.Forms.TreeNode treeNode6 = new System.Windows.Forms.TreeNode("One-handed", new System.Windows.Forms.TreeNode[] {
            treeNode1,
            treeNode2,
            treeNode3,
            treeNode4,
            treeNode5});
            System.Windows.Forms.TreeNode treeNode7 = new System.Windows.Forms.TreeNode("Broadsword");
            System.Windows.Forms.TreeNode treeNode8 = new System.Windows.Forms.TreeNode("Battle axe");
            System.Windows.Forms.TreeNode treeNode9 = new System.Windows.Forms.TreeNode("Spear");
            System.Windows.Forms.TreeNode treeNode10 = new System.Windows.Forms.TreeNode("Two-handed", new System.Windows.Forms.TreeNode[] {
            treeNode7,
            treeNode8,
            treeNode9});
            System.Windows.Forms.TreeNode treeNode11 = new System.Windows.Forms.TreeNode("Weapons", new System.Windows.Forms.TreeNode[] {
            treeNode6,
            treeNode10});
            System.Windows.Forms.TreeNode treeNode12 = new System.Windows.Forms.TreeNode("Helmet");
            System.Windows.Forms.TreeNode treeNode13 = new System.Windows.Forms.TreeNode("Chest");
            System.Windows.Forms.TreeNode treeNode14 = new System.Windows.Forms.TreeNode("Legs");
            System.Windows.Forms.TreeNode treeNode15 = new System.Windows.Forms.TreeNode("Gloves");
            System.Windows.Forms.TreeNode treeNode16 = new System.Windows.Forms.TreeNode("Boots");
            System.Windows.Forms.TreeNode treeNode17 = new System.Windows.Forms.TreeNode("Necklace");
            System.Windows.Forms.TreeNode treeNode18 = new System.Windows.Forms.TreeNode("Ring");
            System.Windows.Forms.TreeNode treeNode19 = new System.Windows.Forms.TreeNode("Equipment", new System.Windows.Forms.TreeNode[] {
            treeNode11,
            treeNode12,
            treeNode13,
            treeNode14,
            treeNode15,
            treeNode16,
            treeNode17,
            treeNode18});
            System.Windows.Forms.TreeNode treeNode20 = new System.Windows.Forms.TreeNode("Potions");
            System.Windows.Forms.TreeNode treeNode21 = new System.Windows.Forms.TreeNode("Cloth");
            System.Windows.Forms.TreeNode treeNode22 = new System.Windows.Forms.TreeNode("Leather");
            System.Windows.Forms.TreeNode treeNode23 = new System.Windows.Forms.TreeNode("Metal");
            System.Windows.Forms.TreeNode treeNode24 = new System.Windows.Forms.TreeNode("Ethereal");
            System.Windows.Forms.TreeNode treeNode25 = new System.Windows.Forms.TreeNode("Crafting", new System.Windows.Forms.TreeNode[] {
            treeNode21,
            treeNode22,
            treeNode23,
            treeNode24});
            System.Windows.Forms.TreeNode treeNode26 = new System.Windows.Forms.TreeNode("Quest Item");
            System.Windows.Forms.TreeNode treeNode27 = new System.Windows.Forms.TreeNode("Junk");
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ItemEditor));
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.btnClear = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.lbUseEffects = new System.Windows.Forms.ListBox();
            this.lbEquipEffects = new System.Windows.Forms.ListBox();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.tsiNew = new System.Windows.Forms.ToolStripMenuItem();
            this.tsiEdit = new System.Windows.Forms.ToolStripMenuItem();
            this.tsiRemove = new System.Windows.Forms.ToolStripMenuItem();
            this.nudSellValue = new System.Windows.Forms.NumericUpDown();
            this.nudLevel = new System.Windows.Forms.NumericUpDown();
            this.pbItemArtwork = new System.Windows.Forms.PictureBox();
            this.label5 = new System.Windows.Forms.Label();
            this.tvType = new System.Windows.Forms.TreeView();
            this.tbName = new System.Windows.Forms.TextBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.checkBox1 = new System.Windows.Forms.CheckBox();
            this.toolTip = new System.Windows.Forms.ToolTip(this.components);
            this.tabPage5 = new System.Windows.Forms.TabPage();
            this.tabPage4 = new System.Windows.Forms.TabPage();
            this.tcEffects = new System.Windows.Forms.TabControl();
            this.tbDescription = new System.Windows.Forms.RichTextBox();
            this.labelRemainingChars = new System.Windows.Forms.Label();
            this.errorProvider = new System.Windows.Forms.ErrorProvider(this.components);
            this.groupBox3.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudSellValue)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudLevel)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbItemArtwork)).BeginInit();
            this.tabPage5.SuspendLayout();
            this.tabPage4.SuspendLayout();
            this.tcEffects.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider)).BeginInit();
            this.SuspendLayout();
            // 
            // btnClear
            // 
            this.btnClear.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.btnClear.Location = new System.Drawing.Point(383, 499);
            this.btnClear.Name = "btnClear";
            this.btnClear.Size = new System.Drawing.Size(75, 23);
            this.btnClear.TabIndex = 12;
            this.btnClear.Text = "Close";
            this.btnClear.UseVisualStyleBackColor = true;
            // 
            // btnSave
            // 
            this.btnSave.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Right)));
            this.btnSave.Location = new System.Drawing.Point(464, 499);
            this.btnSave.Name = "btnSave";
            this.btnSave.Size = new System.Drawing.Size(75, 23);
            this.btnSave.TabIndex = 11;
            this.btnSave.Text = "Save";
            this.btnSave.UseVisualStyleBackColor = true;
            this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
            // 
            // groupBox3
            // 
            this.groupBox3.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.groupBox3.Controls.Add(this.tcEffects);
            this.groupBox3.Controls.Add(this.menuStrip1);
            this.groupBox3.Location = new System.Drawing.Point(15, 252);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(524, 241);
            this.groupBox3.TabIndex = 63;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Effects";
            // 
            // lbUseEffects
            // 
            this.lbUseEffects.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.lbUseEffects.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lbUseEffects.FormattingEnabled = true;
            this.lbUseEffects.Location = new System.Drawing.Point(3, 3);
            this.lbUseEffects.Name = "lbUseEffects";
            this.lbUseEffects.Size = new System.Drawing.Size(504, 166);
            this.lbUseEffects.TabIndex = 0;
            // 
            // lbEquipEffects
            // 
            this.lbEquipEffects.BorderStyle = System.Windows.Forms.BorderStyle.None;
            this.lbEquipEffects.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lbEquipEffects.FormattingEnabled = true;
            this.lbEquipEffects.Location = new System.Drawing.Point(3, 3);
            this.lbEquipEffects.Name = "lbEquipEffects";
            this.lbEquipEffects.Size = new System.Drawing.Size(504, 166);
            this.lbEquipEffects.TabIndex = 1;
            // 
            // menuStrip1
            // 
            this.menuStrip1.Dock = System.Windows.Forms.DockStyle.Bottom;
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsiNew,
            this.tsiEdit,
            this.tsiRemove});
            this.menuStrip1.Location = new System.Drawing.Point(3, 214);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(518, 24);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // tsiNew
            // 
            this.tsiNew.Name = "tsiNew";
            this.tsiNew.Size = new System.Drawing.Size(43, 20);
            this.tsiNew.Text = "New";
            this.tsiNew.Click += new System.EventHandler(this.tsiNew_Click);
            // 
            // tsiEdit
            // 
            this.tsiEdit.Name = "tsiEdit";
            this.tsiEdit.Size = new System.Drawing.Size(39, 20);
            this.tsiEdit.Text = "Edit";
            // 
            // tsiRemove
            // 
            this.tsiRemove.Name = "tsiRemove";
            this.tsiRemove.Size = new System.Drawing.Size(62, 20);
            this.tsiRemove.Text = "Remove";
            // 
            // nudSellValue
            // 
            this.nudSellValue.Location = new System.Drawing.Point(81, 58);
            this.nudSellValue.Maximum = new decimal(new int[] {
            99999,
            0,
            0,
            0});
            this.nudSellValue.Name = "nudSellValue";
            this.nudSellValue.Size = new System.Drawing.Size(77, 20);
            this.nudSellValue.TabIndex = 62;
            this.nudSellValue.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            // 
            // nudLevel
            // 
            this.nudLevel.Location = new System.Drawing.Point(81, 32);
            this.nudLevel.Maximum = new decimal(new int[] {
            20,
            0,
            0,
            0});
            this.nudLevel.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudLevel.Name = "nudLevel";
            this.nudLevel.Size = new System.Drawing.Size(77, 20);
            this.nudLevel.TabIndex = 61;
            this.nudLevel.TextAlign = System.Windows.Forms.HorizontalAlignment.Right;
            this.nudLevel.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // pbItemArtwork
            // 
            this.pbItemArtwork.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.pbItemArtwork.BackColor = System.Drawing.SystemColors.Control;
            this.pbItemArtwork.BorderStyle = System.Windows.Forms.BorderStyle.Fixed3D;
            this.pbItemArtwork.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pbItemArtwork.Image = global::SQEditor.Properties.Resources.close_button_over;
            this.pbItemArtwork.Location = new System.Drawing.Point(475, 6);
            this.pbItemArtwork.Name = "pbItemArtwork";
            this.pbItemArtwork.Size = new System.Drawing.Size(64, 64);
            this.pbItemArtwork.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbItemArtwork.TabIndex = 60;
            this.pbItemArtwork.TabStop = false;
            this.pbItemArtwork.Click += new System.EventHandler(this.pbItemArtwork_Click);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(12, 60);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(57, 13);
            this.label5.TabIndex = 59;
            this.label5.Text = "Sell Value:";
            // 
            // tvType
            // 
            this.tvType.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tvType.FullRowSelect = true;
            this.tvType.HideSelection = false;
            this.tvType.Location = new System.Drawing.Point(81, 152);
            this.tvType.Name = "tvType";
            treeNode1.Name = "Node30";
            treeNode1.Text = "Sword";
            treeNode2.Name = "Node31";
            treeNode2.Text = "Axe";
            treeNode3.Name = "Node32";
            treeNode3.Text = "Mace";
            treeNode4.Name = "Node33";
            treeNode4.Text = "Dagger";
            treeNode5.Name = "Node34";
            treeNode5.Text = "Flail";
            treeNode6.Name = "Node28";
            treeNode6.Text = "One-handed";
            treeNode7.Name = "Node36";
            treeNode7.Text = "Broadsword";
            treeNode8.Name = "Node38";
            treeNode8.Text = "Battle axe";
            treeNode9.Name = "Node39";
            treeNode9.Text = "Spear";
            treeNode10.Name = "Node29";
            treeNode10.Text = "Two-handed";
            treeNode11.Name = "Node15";
            treeNode11.Text = "Weapons";
            treeNode12.Name = "Node5";
            treeNode12.Text = "Helmet";
            treeNode13.Name = "Node17";
            treeNode13.Text = "Chest";
            treeNode14.Name = "Node19";
            treeNode14.Text = "Legs";
            treeNode15.Name = "Node20";
            treeNode15.Text = "Gloves";
            treeNode16.Name = "Node21";
            treeNode16.Text = "Boots";
            treeNode17.Name = "Node22";
            treeNode17.Text = "Necklace";
            treeNode18.Name = "Node23";
            treeNode18.Text = "Ring";
            treeNode19.Name = "Node0";
            treeNode19.Text = "Equipment";
            treeNode20.Name = "Node2";
            treeNode20.Text = "Potions";
            treeNode21.Name = "Node42";
            treeNode21.Text = "Cloth";
            treeNode22.Name = "Node41";
            treeNode22.Text = "Leather";
            treeNode23.Name = "Node43";
            treeNode23.Text = "Metal";
            treeNode24.Name = "Node44";
            treeNode24.Text = "Ethereal";
            treeNode25.Name = "Node3";
            treeNode25.Text = "Crafting";
            treeNode26.Name = "Node4";
            treeNode26.Text = "Quest Item";
            treeNode27.Name = "Node1";
            treeNode27.Text = "Junk";
            this.tvType.Nodes.AddRange(new System.Windows.Forms.TreeNode[] {
            treeNode19,
            treeNode20,
            treeNode25,
            treeNode26,
            treeNode27});
            this.tvType.Size = new System.Drawing.Size(458, 94);
            this.tvType.TabIndex = 58;
            // 
            // tbName
            // 
            this.tbName.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tbName.Location = new System.Drawing.Point(81, 6);
            this.tbName.Name = "tbName";
            this.tbName.Size = new System.Drawing.Size(388, 20);
            this.tbName.TabIndex = 53;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(12, 152);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(34, 13);
            this.label4.TabIndex = 57;
            this.label4.Text = "Type:";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(38, 13);
            this.label1.TabIndex = 52;
            this.label1.Text = "Name:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 34);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(36, 13);
            this.label3.TabIndex = 56;
            this.label3.Text = "Level:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 87);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(63, 26);
            this.label2.TabIndex = 54;
            this.label2.Text = "Description:\r\n(optional)";
            // 
            // checkBox1
            // 
            this.checkBox1.Checked = true;
            this.checkBox1.CheckState = System.Windows.Forms.CheckState.Checked;
            this.checkBox1.Location = new System.Drawing.Point(164, 57);
            this.checkBox1.Name = "checkBox1";
            this.checkBox1.Size = new System.Drawing.Size(73, 20);
            this.checkBox1.TabIndex = 64;
            this.checkBox1.Text = "Automatic";
            this.checkBox1.UseVisualStyleBackColor = true;
            // 
            // toolTip
            // 
            this.toolTip.AutomaticDelay = 50;
            this.toolTip.AutoPopDelay = 5000;
            this.toolTip.InitialDelay = 50;
            this.toolTip.ReshowDelay = 10;
            // 
            // tabPage5
            // 
            this.tabPage5.Controls.Add(this.lbEquipEffects);
            this.tabPage5.Location = new System.Drawing.Point(4, 22);
            this.tabPage5.Name = "tabPage5";
            this.tabPage5.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage5.Size = new System.Drawing.Size(510, 172);
            this.tabPage5.TabIndex = 1;
            this.tabPage5.Text = "Equip";
            this.tabPage5.UseVisualStyleBackColor = true;
            // 
            // tabPage4
            // 
            this.tabPage4.Controls.Add(this.lbUseEffects);
            this.tabPage4.Location = new System.Drawing.Point(4, 22);
            this.tabPage4.Name = "tabPage4";
            this.tabPage4.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage4.Size = new System.Drawing.Size(510, 172);
            this.tabPage4.TabIndex = 0;
            this.tabPage4.Text = "Use";
            this.tabPage4.UseVisualStyleBackColor = true;
            // 
            // tcEffects
            // 
            this.tcEffects.Controls.Add(this.tabPage4);
            this.tcEffects.Controls.Add(this.tabPage5);
            this.tcEffects.Dock = System.Windows.Forms.DockStyle.Fill;
            this.tcEffects.Location = new System.Drawing.Point(3, 16);
            this.tcEffects.Name = "tcEffects";
            this.tcEffects.SelectedIndex = 0;
            this.tcEffects.Size = new System.Drawing.Size(518, 198);
            this.tcEffects.TabIndex = 0;
            // 
            // tbDescription
            // 
            this.tbDescription.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tbDescription.DetectUrls = false;
            this.tbDescription.Location = new System.Drawing.Point(81, 84);
            this.tbDescription.MaxLength = 100;
            this.tbDescription.Name = "tbDescription";
            this.tbDescription.Size = new System.Drawing.Size(458, 62);
            this.tbDescription.TabIndex = 65;
            this.tbDescription.Text = "A seemingly uninteresting object.";
            this.tbDescription.TextChanged += new System.EventHandler(this.tbDescription_TextChanged);
            // 
            // labelRemainingChars
            // 
            this.labelRemainingChars.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Right)));
            this.labelRemainingChars.BackColor = System.Drawing.Color.White;
            this.labelRemainingChars.ImageAlign = System.Drawing.ContentAlignment.MiddleRight;
            this.labelRemainingChars.Location = new System.Drawing.Point(469, 121);
            this.labelRemainingChars.Name = "labelRemainingChars";
            this.labelRemainingChars.Size = new System.Drawing.Size(68, 23);
            this.labelRemainingChars.TabIndex = 67;
            this.labelRemainingChars.Text = "0 / 100";
            this.labelRemainingChars.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // errorProvider
            // 
            this.errorProvider.BlinkStyle = System.Windows.Forms.ErrorBlinkStyle.NeverBlink;
            this.errorProvider.ContainerControl = this;
            this.errorProvider.RightToLeft = true;
            // 
            // ItemEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(551, 534);
            this.Controls.Add(this.labelRemainingChars);
            this.Controls.Add(this.tbDescription);
            this.Controls.Add(this.checkBox1);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.nudSellValue);
            this.Controls.Add(this.nudLevel);
            this.Controls.Add(this.pbItemArtwork);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.tvType);
            this.Controls.Add(this.tbName);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnSave);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MinimumSize = new System.Drawing.Size(567, 550);
            this.Name = "ItemEditor";
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Show;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Item Editor | StoneQuest";
            this.Load += new System.EventHandler(this.ItemEditor_Load);
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudSellValue)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudLevel)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbItemArtwork)).EndInit();
            this.tabPage5.ResumeLayout(false);
            this.tabPage4.ResumeLayout(false);
            this.tcEffects.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.errorProvider)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem tsiNew;
        private System.Windows.Forms.ToolStripMenuItem tsiEdit;
        private System.Windows.Forms.ToolStripMenuItem tsiRemove;
        private System.Windows.Forms.NumericUpDown nudSellValue;
        private System.Windows.Forms.NumericUpDown nudLevel;
        private System.Windows.Forms.PictureBox pbItemArtwork;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TreeView tvType;
        private System.Windows.Forms.TextBox tbName;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ListBox lbUseEffects;
        private System.Windows.Forms.ListBox lbEquipEffects;
        private System.Windows.Forms.CheckBox checkBox1;
        private System.Windows.Forms.ToolTip toolTip;
        private System.Windows.Forms.TabControl tcEffects;
        private System.Windows.Forms.TabPage tabPage4;
        private System.Windows.Forms.TabPage tabPage5;
        private System.Windows.Forms.RichTextBox tbDescription;
        private System.Windows.Forms.Label labelRemainingChars;
        private System.Windows.Forms.ErrorProvider errorProvider;

    }
}