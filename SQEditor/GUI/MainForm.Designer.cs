using SQEditor.GUI.Tiles;
namespace SQEditor.GUI
{
    partial class MainForm
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
            System.Windows.Forms.TreeNode treeNode1 = new System.Windows.Forms.TreeNode("Items");
            System.Windows.Forms.TreeNode treeNode2 = new System.Windows.Forms.TreeNode("NPCs");
            System.Windows.Forms.TreeNode treeNode3 = new System.Windows.Forms.TreeNode("Doodads");
            System.Windows.Forms.TreeNode treeNode4 = new System.Windows.Forms.TreeNode("Objects", new System.Windows.Forms.TreeNode[] {
            treeNode1,
            treeNode2,
            treeNode3});
            System.Windows.Forms.TreeNode treeNode5 = new System.Windows.Forms.TreeNode("Campaign");
            System.Windows.Forms.TreeNode treeNode6 = new System.Windows.Forms.TreeNode("Zones");
            System.Windows.Forms.TreeNode treeNode7 = new System.Windows.Forms.TreeNode("Quests");
            System.Windows.Forms.TreeNode treeNode8 = new System.Windows.Forms.TreeNode("Point of Interest");
            System.Windows.Forms.TreeNode treeNode9 = new System.Windows.Forms.TreeNode("Campaign", new System.Windows.Forms.TreeNode[] {
            treeNode5,
            treeNode6,
            treeNode7,
            treeNode8});
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MainForm));
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.importToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.newToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.objectToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tsiNewItem = new System.Windows.Forms.ToolStripMenuItem();
            this.tsiNewNPC = new System.Windows.Forms.ToolStripMenuItem();
            this.tsiNewDoodad = new System.Windows.Forms.ToolStripMenuItem();
            this.campaignToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.campaignToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.zoneToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.questToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.pointOfInterestToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.itemToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.splitContainer1 = new System.Windows.Forms.SplitContainer();
            this.splitContainer2 = new System.Windows.Forms.SplitContainer();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.treeView1 = new System.Windows.Forms.TreeView();
            this.button3 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.ucTileEditor1 = new SQEditor.GUI.Tiles.ucTileOverview();
            this.menuStrip1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).BeginInit();
            this.splitContainer1.Panel2.SuspendLayout();
            this.splitContainer1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer2)).BeginInit();
            this.splitContainer2.Panel1.SuspendLayout();
            this.splitContainer2.Panel2.SuspendLayout();
            this.splitContainer2.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.BackgroundImage = global::SQEditor.Properties.Resources.menu_border;
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.importToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(956, 24);
            this.menuStrip1.TabIndex = 8;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // importToolStripMenuItem
            // 
            this.importToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.newToolStripMenuItem,
            this.itemToolStripMenuItem1});
            this.importToolStripMenuItem.Name = "importToolStripMenuItem";
            this.importToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.importToolStripMenuItem.Text = "File";
            // 
            // newToolStripMenuItem
            // 
            this.newToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.objectToolStripMenuItem,
            this.campaignToolStripMenuItem});
            this.newToolStripMenuItem.Name = "newToolStripMenuItem";
            this.newToolStripMenuItem.Size = new System.Drawing.Size(110, 22);
            this.newToolStripMenuItem.Text = "New";
            // 
            // objectToolStripMenuItem
            // 
            this.objectToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.tsiNewItem,
            this.tsiNewNPC,
            this.tsiNewDoodad});
            this.objectToolStripMenuItem.Name = "objectToolStripMenuItem";
            this.objectToolStripMenuItem.Size = new System.Drawing.Size(129, 22);
            this.objectToolStripMenuItem.Text = "Object";
            // 
            // tsiNewItem
            // 
            this.tsiNewItem.Name = "tsiNewItem";
            this.tsiNewItem.Size = new System.Drawing.Size(116, 22);
            this.tsiNewItem.Text = "Item";
            this.tsiNewItem.Click += new System.EventHandler(this.tsiNewItem_Click);
            // 
            // tsiNewNPC
            // 
            this.tsiNewNPC.Name = "tsiNewNPC";
            this.tsiNewNPC.Size = new System.Drawing.Size(116, 22);
            this.tsiNewNPC.Text = "NPC";
            // 
            // tsiNewDoodad
            // 
            this.tsiNewDoodad.Name = "tsiNewDoodad";
            this.tsiNewDoodad.Size = new System.Drawing.Size(116, 22);
            this.tsiNewDoodad.Text = "Doodad";
            // 
            // campaignToolStripMenuItem
            // 
            this.campaignToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.campaignToolStripMenuItem1,
            this.zoneToolStripMenuItem,
            this.questToolStripMenuItem,
            this.pointOfInterestToolStripMenuItem});
            this.campaignToolStripMenuItem.Name = "campaignToolStripMenuItem";
            this.campaignToolStripMenuItem.Size = new System.Drawing.Size(129, 22);
            this.campaignToolStripMenuItem.Text = "Campaign";
            // 
            // campaignToolStripMenuItem1
            // 
            this.campaignToolStripMenuItem1.Name = "campaignToolStripMenuItem1";
            this.campaignToolStripMenuItem1.Size = new System.Drawing.Size(158, 22);
            this.campaignToolStripMenuItem1.Text = "Campaign";
            // 
            // zoneToolStripMenuItem
            // 
            this.zoneToolStripMenuItem.Name = "zoneToolStripMenuItem";
            this.zoneToolStripMenuItem.Size = new System.Drawing.Size(158, 22);
            this.zoneToolStripMenuItem.Text = "Zone";
            // 
            // questToolStripMenuItem
            // 
            this.questToolStripMenuItem.Name = "questToolStripMenuItem";
            this.questToolStripMenuItem.Size = new System.Drawing.Size(158, 22);
            this.questToolStripMenuItem.Text = "Quest";
            // 
            // pointOfInterestToolStripMenuItem
            // 
            this.pointOfInterestToolStripMenuItem.Name = "pointOfInterestToolStripMenuItem";
            this.pointOfInterestToolStripMenuItem.Size = new System.Drawing.Size(158, 22);
            this.pointOfInterestToolStripMenuItem.Text = "Point of Interest";
            // 
            // itemToolStripMenuItem1
            // 
            this.itemToolStripMenuItem1.Name = "itemToolStripMenuItem1";
            this.itemToolStripMenuItem1.Size = new System.Drawing.Size(110, 22);
            this.itemToolStripMenuItem1.Text = "Import";
            // 
            // splitContainer1
            // 
            this.splitContainer1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer1.Location = new System.Drawing.Point(0, 24);
            this.splitContainer1.Name = "splitContainer1";
            // 
            // splitContainer1.Panel2
            // 
            this.splitContainer1.Panel2.Controls.Add(this.splitContainer2);
            this.splitContainer1.Size = new System.Drawing.Size(956, 608);
            this.splitContainer1.SplitterDistance = 431;
            this.splitContainer1.TabIndex = 9;
            // 
            // splitContainer2
            // 
            this.splitContainer2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.splitContainer2.Location = new System.Drawing.Point(0, 0);
            this.splitContainer2.Name = "splitContainer2";
            this.splitContainer2.Orientation = System.Windows.Forms.Orientation.Horizontal;
            // 
            // splitContainer2.Panel1
            // 
            this.splitContainer2.Panel1.Controls.Add(this.groupBox2);
            // 
            // splitContainer2.Panel2
            // 
            this.splitContainer2.Panel2.BackColor = System.Drawing.SystemColors.Control;
            this.splitContainer2.Panel2.Controls.Add(this.groupBox1);
            this.splitContainer2.Panel2.Controls.Add(this.button3);
            this.splitContainer2.Panel2.Controls.Add(this.button2);
            this.splitContainer2.Size = new System.Drawing.Size(521, 608);
            this.splitContainer2.SplitterDistance = 161;
            this.splitContainer2.TabIndex = 0;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.treeView1);
            this.groupBox1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.groupBox1.Location = new System.Drawing.Point(0, 0);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(521, 443);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Item List";
            // 
            // treeView1
            // 
            this.treeView1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.treeView1.Location = new System.Drawing.Point(3, 16);
            this.treeView1.Name = "treeView1";
            treeNode1.Name = "Node3";
            treeNode1.Text = "Items";
            treeNode2.Name = "Node5";
            treeNode2.Text = "NPCs";
            treeNode3.Name = "Node6";
            treeNode3.Text = "Doodads";
            treeNode4.Name = "Node2";
            treeNode4.Text = "Objects";
            treeNode5.Name = "Node9";
            treeNode5.Text = "Campaign";
            treeNode6.Name = "Node11";
            treeNode6.Text = "Zones";
            treeNode7.Name = "Node12";
            treeNode7.Text = "Quests";
            treeNode8.Name = "Node13";
            treeNode8.Text = "Point of Interest";
            treeNode9.Name = "Node7";
            treeNode9.Text = "Campaign";
            this.treeView1.Nodes.AddRange(new System.Windows.Forms.TreeNode[] {
            treeNode4,
            treeNode9});
            this.treeView1.Size = new System.Drawing.Size(515, 424);
            this.treeView1.TabIndex = 11;
            // 
            // button3
            // 
            this.button3.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.button3.Location = new System.Drawing.Point(84, 408);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(75, 23);
            this.button3.TabIndex = 14;
            this.button3.Text = "Delete";
            this.button3.UseVisualStyleBackColor = true;
            // 
            // button2
            // 
            this.button2.Anchor = ((System.Windows.Forms.AnchorStyles)((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left)));
            this.button2.Location = new System.Drawing.Point(3, 408);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(75, 23);
            this.button2.TabIndex = 13;
            this.button2.Text = "Edit";
            this.button2.UseVisualStyleBackColor = true;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.ucTileEditor1);
            this.groupBox2.Dock = System.Windows.Forms.DockStyle.Fill;
            this.groupBox2.Location = new System.Drawing.Point(0, 0);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(521, 161);
            this.groupBox2.TabIndex = 0;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Tiles";
            // 
            // ucTileEditor1
            // 
            this.ucTileEditor1.Dock = System.Windows.Forms.DockStyle.Fill;
            this.ucTileEditor1.Location = new System.Drawing.Point(3, 16);
            this.ucTileEditor1.Name = "ucTileEditor1";
            this.ucTileEditor1.Size = new System.Drawing.Size(515, 142);
            this.ucTileEditor1.TabIndex = 1;
            // 
            // MainForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(956, 632);
            this.Controls.Add(this.splitContainer1);
            this.Controls.Add(this.menuStrip1);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "MainForm";
            this.Text = "Editor | StoneQuest";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.splitContainer1.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer1)).EndInit();
            this.splitContainer1.ResumeLayout(false);
            this.splitContainer2.Panel1.ResumeLayout(false);
            this.splitContainer2.Panel2.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.splitContainer2)).EndInit();
            this.splitContainer2.ResumeLayout(false);
            this.groupBox1.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem importToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem newToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem objectToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem tsiNewItem;
        private System.Windows.Forms.ToolStripMenuItem tsiNewNPC;
        private System.Windows.Forms.ToolStripMenuItem tsiNewDoodad;
        private System.Windows.Forms.ToolStripMenuItem campaignToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem campaignToolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem zoneToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem questToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem pointOfInterestToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem itemToolStripMenuItem1;
        private System.Windows.Forms.SplitContainer splitContainer1;
        private System.Windows.Forms.SplitContainer splitContainer2;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.TreeView treeView1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private ucTileOverview ucTileEditor1;
    }
}

