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
            System.Windows.Forms.TreeNode treeNode55 = new System.Windows.Forms.TreeNode("Sword");
            System.Windows.Forms.TreeNode treeNode56 = new System.Windows.Forms.TreeNode("Axe");
            System.Windows.Forms.TreeNode treeNode57 = new System.Windows.Forms.TreeNode("Mace");
            System.Windows.Forms.TreeNode treeNode58 = new System.Windows.Forms.TreeNode("Dagger");
            System.Windows.Forms.TreeNode treeNode59 = new System.Windows.Forms.TreeNode("Flail");
            System.Windows.Forms.TreeNode treeNode60 = new System.Windows.Forms.TreeNode("One-handed", new System.Windows.Forms.TreeNode[] {
            treeNode55,
            treeNode56,
            treeNode57,
            treeNode58,
            treeNode59});
            System.Windows.Forms.TreeNode treeNode61 = new System.Windows.Forms.TreeNode("Broadsword");
            System.Windows.Forms.TreeNode treeNode62 = new System.Windows.Forms.TreeNode("Battle axe");
            System.Windows.Forms.TreeNode treeNode63 = new System.Windows.Forms.TreeNode("Spear");
            System.Windows.Forms.TreeNode treeNode64 = new System.Windows.Forms.TreeNode("Two-handed", new System.Windows.Forms.TreeNode[] {
            treeNode61,
            treeNode62,
            treeNode63});
            System.Windows.Forms.TreeNode treeNode65 = new System.Windows.Forms.TreeNode("Weapons", new System.Windows.Forms.TreeNode[] {
            treeNode60,
            treeNode64});
            System.Windows.Forms.TreeNode treeNode66 = new System.Windows.Forms.TreeNode("Helmet");
            System.Windows.Forms.TreeNode treeNode67 = new System.Windows.Forms.TreeNode("Chest");
            System.Windows.Forms.TreeNode treeNode68 = new System.Windows.Forms.TreeNode("Legs");
            System.Windows.Forms.TreeNode treeNode69 = new System.Windows.Forms.TreeNode("Gloves");
            System.Windows.Forms.TreeNode treeNode70 = new System.Windows.Forms.TreeNode("Boots");
            System.Windows.Forms.TreeNode treeNode71 = new System.Windows.Forms.TreeNode("Necklace");
            System.Windows.Forms.TreeNode treeNode72 = new System.Windows.Forms.TreeNode("Ring");
            System.Windows.Forms.TreeNode treeNode73 = new System.Windows.Forms.TreeNode("Equipment", new System.Windows.Forms.TreeNode[] {
            treeNode65,
            treeNode66,
            treeNode67,
            treeNode68,
            treeNode69,
            treeNode70,
            treeNode71,
            treeNode72});
            System.Windows.Forms.TreeNode treeNode74 = new System.Windows.Forms.TreeNode("Potions");
            System.Windows.Forms.TreeNode treeNode75 = new System.Windows.Forms.TreeNode("Cloth");
            System.Windows.Forms.TreeNode treeNode76 = new System.Windows.Forms.TreeNode("Leather");
            System.Windows.Forms.TreeNode treeNode77 = new System.Windows.Forms.TreeNode("Metal");
            System.Windows.Forms.TreeNode treeNode78 = new System.Windows.Forms.TreeNode("Ethereal");
            System.Windows.Forms.TreeNode treeNode79 = new System.Windows.Forms.TreeNode("Crafting", new System.Windows.Forms.TreeNode[] {
            treeNode75,
            treeNode76,
            treeNode77,
            treeNode78});
            System.Windows.Forms.TreeNode treeNode80 = new System.Windows.Forms.TreeNode("Quest Item");
            System.Windows.Forms.TreeNode treeNode81 = new System.Windows.Forms.TreeNode("Junk");
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(ItemEditor));
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.btnClear = new System.Windows.Forms.Button();
            this.btnSave = new System.Windows.Forms.Button();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.tcEffects = new System.Windows.Forms.TabControl();
            this.tabPage4 = new System.Windows.Forms.TabPage();
            this.lbUseEffects = new System.Windows.Forms.ListBox();
            this.tabPage5 = new System.Windows.Forms.TabPage();
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
            this.tbDescription = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.checkBox1 = new System.Windows.Forms.CheckBox();
            this.toolTip = new System.Windows.Forms.ToolTip(this.components);
            this.groupBox3.SuspendLayout();
            this.tcEffects.SuspendLayout();
            this.tabPage4.SuspendLayout();
            this.tabPage5.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudSellValue)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudLevel)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbItemArtwork)).BeginInit();
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
            // 
            // groupBox3
            // 
            this.groupBox3.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
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
            // lbUseEffects
            // 
            this.lbUseEffects.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lbUseEffects.FormattingEnabled = true;
            this.lbUseEffects.Location = new System.Drawing.Point(3, 3);
            this.lbUseEffects.Name = "lbUseEffects";
            this.lbUseEffects.Size = new System.Drawing.Size(504, 166);
            this.lbUseEffects.TabIndex = 0;
            // 
            // tabPage5
            // 
            this.tabPage5.Controls.Add(this.lbEquipEffects);
            this.tabPage5.Location = new System.Drawing.Point(4, 22);
            this.tabPage5.Name = "tabPage5";
            this.tabPage5.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage5.Size = new System.Drawing.Size(510, 150);
            this.tabPage5.TabIndex = 1;
            this.tabPage5.Text = "Equip";
            this.tabPage5.UseVisualStyleBackColor = true;
            // 
            // lbEquipEffects
            // 
            this.lbEquipEffects.Dock = System.Windows.Forms.DockStyle.Fill;
            this.lbEquipEffects.FormattingEnabled = true;
            this.lbEquipEffects.Location = new System.Drawing.Point(3, 3);
            this.lbEquipEffects.Name = "lbEquipEffects";
            this.lbEquipEffects.Size = new System.Drawing.Size(504, 144);
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
            this.tvType.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tvType.FullRowSelect = true;
            this.tvType.HideSelection = false;
            this.tvType.Location = new System.Drawing.Point(81, 152);
            this.tvType.Name = "tvType";
            treeNode55.Name = "Node30";
            treeNode55.Text = "Sword";
            treeNode56.Name = "Node31";
            treeNode56.Text = "Axe";
            treeNode57.Name = "Node32";
            treeNode57.Text = "Mace";
            treeNode58.Name = "Node33";
            treeNode58.Text = "Dagger";
            treeNode59.Name = "Node34";
            treeNode59.Text = "Flail";
            treeNode60.Name = "Node28";
            treeNode60.Text = "One-handed";
            treeNode61.Name = "Node36";
            treeNode61.Text = "Broadsword";
            treeNode62.Name = "Node38";
            treeNode62.Text = "Battle axe";
            treeNode63.Name = "Node39";
            treeNode63.Text = "Spear";
            treeNode64.Name = "Node29";
            treeNode64.Text = "Two-handed";
            treeNode65.Name = "Node15";
            treeNode65.Text = "Weapons";
            treeNode66.Name = "Node5";
            treeNode66.Text = "Helmet";
            treeNode67.Name = "Node17";
            treeNode67.Text = "Chest";
            treeNode68.Name = "Node19";
            treeNode68.Text = "Legs";
            treeNode69.Name = "Node20";
            treeNode69.Text = "Gloves";
            treeNode70.Name = "Node21";
            treeNode70.Text = "Boots";
            treeNode71.Name = "Node22";
            treeNode71.Text = "Necklace";
            treeNode72.Name = "Node23";
            treeNode72.Text = "Ring";
            treeNode73.Name = "Node0";
            treeNode73.Text = "Equipment";
            treeNode74.Name = "Node2";
            treeNode74.Text = "Potions";
            treeNode75.Name = "Node42";
            treeNode75.Text = "Cloth";
            treeNode76.Name = "Node41";
            treeNode76.Text = "Leather";
            treeNode77.Name = "Node43";
            treeNode77.Text = "Metal";
            treeNode78.Name = "Node44";
            treeNode78.Text = "Ethereal";
            treeNode79.Name = "Node3";
            treeNode79.Text = "Crafting";
            treeNode80.Name = "Node4";
            treeNode80.Text = "Quest Item";
            treeNode81.Name = "Node1";
            treeNode81.Text = "Junk";
            this.tvType.Nodes.AddRange(new System.Windows.Forms.TreeNode[] {
            treeNode73,
            treeNode74,
            treeNode79,
            treeNode80,
            treeNode81});
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
            // tbDescription
            // 
            this.tbDescription.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tbDescription.Location = new System.Drawing.Point(81, 84);
            this.tbDescription.MaxLength = 200;
            this.tbDescription.Multiline = true;
            this.tbDescription.Name = "tbDescription";
            this.tbDescription.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.tbDescription.Size = new System.Drawing.Size(458, 62);
            this.tbDescription.TabIndex = 55;
            this.tbDescription.Text = "A seemingly uninteresting object.";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 87);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(63, 39);
            this.label2.TabIndex = 54;
            this.label2.Text = "Description:\r\n(200 chars)\r\n(optional)";
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
            // ItemEditor
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(551, 534);
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
            this.Controls.Add(this.tbDescription);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.btnClear);
            this.Controls.Add(this.btnSave);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.MinimumSize = new System.Drawing.Size(567, 550);
            this.Name = "ItemEditor";
            this.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Show;
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterParent;
            this.Text = "Item Editor | StoneQuest";
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.tcEffects.ResumeLayout(false);
            this.tabPage4.ResumeLayout(false);
            this.tabPage5.ResumeLayout(false);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudSellValue)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudLevel)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbItemArtwork)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.Button btnClear;
        private System.Windows.Forms.Button btnSave;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.TabControl tcEffects;
        private System.Windows.Forms.TabPage tabPage4;
        private System.Windows.Forms.TabPage tabPage5;
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
        private System.Windows.Forms.TextBox tbDescription;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ListBox lbUseEffects;
        private System.Windows.Forms.ListBox lbEquipEffects;
        private System.Windows.Forms.CheckBox checkBox1;
        private System.Windows.Forms.ToolTip toolTip;

    }
}